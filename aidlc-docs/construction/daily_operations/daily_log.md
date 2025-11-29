# DailyLog Component

`DailyLog` は、配達員の一日の稼働記録全体を管理する集約ルートです。

## Attributes

| Name | Type | Description |
|---|---|---|
| id | UUID | 一意な識別子 |
| date | Date | 記録日 |
| startTime | DateTime | 稼働開始時刻 |
| endTime | DateTime | 稼働終了時刻 |
| status | Enum | 稼働状態 (WORKING, ON_BREAK, ENDED) |
| breaks | List<Break> | 休憩時間のリスト |
| deliveries | List<Delivery> | 配達記録のリスト |
| expenses | List<Expense> | 経費記録のリスト |

## Behavior

### `startWork()`
稼働を開始し、`startTime` を記録し、`status` を `WORKING` に設定します。

### `endWork()`
稼働を終了し、`endTime` を記録し、`status` を `ENDED` に設定します。

### `startBreak()`
休憩を開始し、新しい `Break` インスタンスを作成して `breaks` リストに追加し、`status` を `ON_BREAK` に設定します。

### `endBreak()`
現在の休憩を終了し、`status` を `WORKING` に戻します。

### `addDelivery(delivery: Delivery)`
新しい配達記録を `deliveries` リストに追加します。

### `addExpense(expense: Expense)`
新しい経費記録を `expenses` リストに追加します。

### `calculateTotalWorkingTime()`
`startTime` と `endTime` から総稼働時間を計算します。

### `calculateTotalBreakTime()`
`breaks` リスト内のすべての休憩時間から合計休憩時間を計算します。

### `calculateNetWorkingTime()`
総稼働時間から合計休憩時間を引いて、実稼働時間を計算します。

### `calculateTotalSales()`
`deliveries` リスト内のすべての配達記録から合計売上を計算します。

## Interactions
- `Break` コンポーネントを子エンティティとして保持します。
- `Delivery` コンポーネントを子エンティティとして保持します。
- `Expense` コンポーネントを子エンティティとして保持します。
