document.addEventListener('DOMContentLoaded', () => {
    // グローバル変数とDOM要素の取得
    const tabLinks = document.querySelectorAll('.tab-link');
    const tabContents = document.querySelectorAll('.tab-content');
    
    // データストア
    let deliveries = [];

    // --- タブ切り替え機能 ---
    tabLinks.forEach(link => {
        link.addEventListener('click', () => {
            const tabId = link.dataset.tab;

            tabLinks.forEach(item => item.classList.remove('active'));
            tabContents.forEach(item => item.classList.remove('active'));

            link.classList.add('active');
            document.getElementById(tabId).classList.add('active');
        });
    });

    // --- トップ画面タブの機能 ---
    const startButton = document.getElementById('startButton');
    const pauseButton = document.getElementById('pauseButton');
    const resumeButton = document.getElementById('resumeButton');
    const timerDisplay = document.getElementById('timer');
    
    let startTime;
    let elapsedTime = 0;
    let timerInterval;

    function formatTime(ms) {
        const totalSeconds = Math.floor(ms / 1000);
        const hours = Math.floor(totalSeconds / 3600).toString().padStart(2, '0');
        const minutes = Math.floor((totalSeconds % 3600) / 60).toString().padStart(2, '0');
        const seconds = (totalSeconds % 60).toString().padStart(2, '0');
        return `${hours}:${minutes}:${seconds}`;
    }

    startButton.addEventListener('click', () => {
        startTime = Date.now() - elapsedTime;
        timerInterval = setInterval(() => {
            elapsedTime = Date.now() - startTime;
            timerDisplay.textContent = formatTime(elapsedTime);
        }, 1000);
        startButton.disabled = true;
        pauseButton.disabled = false;
        resumeButton.disabled = true;
    });

    pauseButton.addEventListener('click', () => {
        clearInterval(timerInterval);
        pauseButton.disabled = true;
        resumeButton.disabled = false;
    });

    resumeButton.addEventListener('click', () => {
        startTime = Date.now() - elapsedTime;
        timerInterval = setInterval(() => {
            elapsedTime = Date.now() - startTime;
            timerDisplay.textContent = formatTime(elapsedTime);
        }, 1000);
        pauseButton.disabled = false;
        resumeButton.disabled = true;
    });

    // --- 収益登録タブの機能 ---
    const deliveryForm = document.getElementById('deliveryForm');
    const deliveryDateTimeInput = document.getElementById('deliveryDateTime');
    const setCurrentTimeButton = document.getElementById('setCurrentTimeButton');

    setCurrentTimeButton.addEventListener('click', () => {
        const now = new Date();
        const year = now.getFullYear();
        const month = (now.getMonth() + 1).toString().padStart(2, '0');
        const day = now.getDate().toString().padStart(2, '0');
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');

        const formattedDateTime = `${year}-${month}-${day}T${hours}:${minutes}`;
        deliveryDateTimeInput.value = formattedDateTime;
    });

    deliveryForm.addEventListener('submit', (e) => {
        e.preventDefault();
        
        const newDelivery = {
            dateTime: document.getElementById('deliveryDateTime').value,
            service: document.getElementById('deliveryService').value,
            amount: parseInt(document.getElementById('deliveryAmount').value, 10),
            id: Date.now()
        };

        deliveries.push(newDelivery);
        alert('登録しました。');
        deliveryForm.reset();
        
        updateTopTabSummary();
        // TODO: ダッシュボードも更新する
    });

    // --- データ更新関数 ---
    function updateTopTabSummary() {
        const totalSalesDisplay = document.getElementById('totalSales');
        const totalDeliveriesDisplay = document.getElementById('totalDeliveries');
        const salesList = document.getElementById('salesList');

        const today = new Date().toISOString().slice(0, 10);
        const todaysDeliveries = deliveries.filter(d => d.dateTime.startsWith(today));

        const totalSales = todaysDeliveries.reduce((sum, d) => sum + d.amount, 0);
        const totalDeliveries = todaysDeliveries.length;

        totalSalesDisplay.textContent = totalSales;
        totalDeliveriesDisplay.textContent = totalDeliveries;
        
        const salesByService = {
            'UberEats': 0,
            '出前館': 0,
            'Wolt': 0,
        };

        todaysDeliveries.forEach(d => {
            if (salesByService.hasOwnProperty(d.service)) {
                salesByService[d.service] += d.amount;
            }
        });

        salesList.innerHTML = '';
        for (const service in salesByService) {
            const li = document.createElement('li');
            li.textContent = `${service}: ${salesByService[service]} 円`;
            salesList.appendChild(li);
        }
    }
    
    // 初期表示
    updateTopTabSummary();
});
