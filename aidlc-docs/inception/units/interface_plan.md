# インターフェース設計計画

このドキュメントは、各作業ユニット間のインターフェースを設計するための計画を概説します。

## ステップ 1: Unit 1 -> Unit 3 インターフェース

-   **目的:** Unit 3がUnit 1から支払いサイクル情報を取得する。
-   **関数:** `getPaymentCycle(companyName: string): PaymentCycleDTO`
-   **DTO:** `PaymentCycleDTO`
    -   `companyName: string` （配達会社名）
    -   `closingDay: int` （締め日）
    -   `paymentDay: int` （支払日）

## ステップ 2: Unit 2 -> Unit 3 インターフェース

-   **目的:** Unit 3がUnit 2から指定期間の売上データを取得する。
-   **関数:** `getSalesData(startDate: date, endDate: date): SalesDataDTO[]`
-   **DTO:** `SalesDataDTO`
    -   `companyName: string` （配達会社名）
    -   `deliveryDateTime: datetime` （配達日時）
    -   `salesAmount: number` （売上金額）

## ステップ 3: Unit 2 -> Unit 4 インターフェース

-   **目的:** Unit 4がUnit 2から指定期間の分析用データを取得する。
-   **関数:** `getAnalyticsData(startDate: date, endDate: date): AnalyticsDataDTO`
-   **DTO:** `AnalyticsDataDTO`
    -   `sales: SalesDataDTO[]`
    -   `expenses: ExpenseDataDTO[]`
-   **DTO:** `ExpenseDataDTO`
    -   `date: date` （日付）
    -   `item: string` （費目）
    -   `amount: number` （金額）

## 承認

- [x] この計画についてレビューと承認を求める。
