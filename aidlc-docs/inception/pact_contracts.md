# PACT契約サンプル

このドキュメントは、ユニット間のAPIおよびイベント駆動のインタラクションを定義するPACT契約のサンプルです。

## API契約: 稼働記録データ取得

Unit 4がUnit 2から分析に必要なデータを取得する際のAPI契約を定義します。

-   **Consumer**: Unit 4: 分析とレポート
-   **Provider**: Unit 2: 日々の稼働記録
-   **Description**: 指定された期間の稼働記録（売上、経費、時間）を取得する。

### Interaction: 期間指定での稼働データ取得リクエスト

`given("指定された期間に稼働記録が存在する")`

`upon receiving("a request to get operational data for a date range")`

**Request:**
```http
GET /operations?from=2023-10-01&to=2023-10-31
Accept: application/json
```

`it will respond with("a list of operational data")`

**Response:**
-   **Status**: `200 OK`
-   **Headers**: `Content-Type: application/json`
-   **Body**:
    ```json
    {
      "data": [
        {
          "date": "2023-10-01",
          "totalSales": 15000,
          "totalExpenses": 1200,
          "duration": "08:30:00",
          "deliveries": [
            { "service": "UberEats", "amount": 8000 },
            { "service": "出前館", "amount": 7000 }
          ]
        },
        {
          "date": "2023-10-02",
          "totalSales": 18000,
          "totalExpenses": 1500,
          "duration": "09:00:00",
          "deliveries": [
            { "service": "Wolt", "amount": 18000 }
          ]
        }
      ],
      "summary": {
        "period": {
          "from": "2023-10-01",
          "to": "2023-10-31"
        },
        "totalSales": 33000,
        "totalExpenses": 2700
      }
    }
    ```

---

## イベント契約: 売上登録イベント

Unit 2が売上を記録した際に発行するイベントの契約を定義します。Unit 3やUnit 4がこのイベントを購読します。

-   **Producer**: Unit 2: 日々の稼働記録
-   **Consumers**: Unit 3, Unit 4
-   **Event**: `SalesRecorded`

### Event Payload

```json
{
  "eventId": "evt_123456789",
  "eventType": "SalesRecorded",
  "timestamp": "2023-10-01T14:30:00Z",
  "data": {
    "operationId": "op_98765",
    "delivery": {
      "service": "UberEats",
      "amount": 1500,
      "recordedAt": "2023-10-01T14:25:10Z"
    }
  }
}
