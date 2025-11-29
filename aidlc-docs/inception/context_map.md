# コンテキストマップ

このドキュメントは、定義された作業ユニット間の関係性を視覚的に表現するコンテキストマップです。

```mermaid
graph TD
    U1["Unit 1:<br>サービス設定"]
    U2["Unit 2:<br>日々の稼働記録"]
    U3["Unit 3:<br>キャッシュフロー管理"]
    U4["Unit 4:<br>分析とレポート"]

    U1 -- "支払いサイクル情報" --> U3
    U2 -- "売上・稼働データ" --> U3
    U2 -- "売上・稼働・経費データ" --> U4

    %% Styling for better visibility
    style U1 fill:#FFF0F0,stroke:#A00,stroke-width:2px,color:#333
    style U2 fill:#FFF0F0,stroke:#A00,stroke-width:2px,color:#333
    style U3 fill:#F0F0FF,stroke:#00A,stroke-width:2px,color:#333
    style U4 fill:#F0F0FF,stroke:#00A,stroke-width:2px,color:#333
```

## 関係性の説明

-   **Unit 1 (サービス設定) & Unit 3 (キャッシュフロー管理)**
    -   Unit 1は支払いサイクルの設定情報（締め日、支払日など）を保持します。
    -   Unit 3はこの情報を利用して、正確な入金予定日を計算します。
    -   関係: Unit 1 (Upstream) -> Unit 3 (Downstream)

-   **Unit 2 (日々の稼働記録) & Unit 3 (キャッシュフロー管理)**
    -   Unit 2は日々の売上データを記録します。
    -   Unit 3はこの売上データを基に、各支払いサイクルで支払われる金額を算出します。
    -   関係: Unit 2 (Upstream) -> Unit 3 (Downstream)

-   **Unit 2 (日々の稼働記録) & Unit 4 (分析とレポート)**
    -   Unit 2は売上、経費、稼働時間など、分析の元となる全ての基礎データを記録します。
    -   Unit 4はこのデータを多角的に分析し、グラフや時給などのレポートを生成します。
    -   関係: Unit 2 (Upstream) -> Unit 4 (Downstream)
