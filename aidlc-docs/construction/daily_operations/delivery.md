# Delivery Component

`Delivery` コンポーネントは、一回の配達とその売上を記録します。

## Attributes

| Name | Type | Description |
|---|---|---|
| id | UUID | 一意な識別子 |
| service | Service | 配達サービスの種類 |
| amount | Money | 売上金額 |
| timestamp | DateTime | 配達完了時刻 |

## Interactions
- `DailyLog` コンポーネントに属します。
- `Service` コンポーネントを参照します。
