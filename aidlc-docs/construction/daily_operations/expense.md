# Expense Component

`Expense` コンポーネントは、一回の経費を記録します。

## Attributes

| Name | Type | Description |
|---|---|---|
| id | UUID | 一意な識別子 |
| category | String | 経費のカテゴリ（例：ガソリン代、備品費） |
| amount | Money | 経費の金額 |
| timestamp | DateTime | 経費発生時刻 |
| description | String | 経費の詳細な説明 |

## Interactions
- `DailyLog` コンポーネントに属します。
