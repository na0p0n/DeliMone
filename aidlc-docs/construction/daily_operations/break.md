# Break Component

`Break` コンポーネントは、一回の休憩時間を記録します。

## Attributes

| Name | Type | Description |
|---|---|---|
| id | UUID | 一意な識別子 |
| startTime | DateTime | 休憩開始時刻 |
| endTime | DateTime | 休憩終了時刻 |

## Behavior

### `start()`
休憩を開始し、`startTime` を記録します。

### `end()`
休憩を終了し、`endTime` を記録します。

### `getDuration()`
`startTime` と `endTime` から休憩時間を計算します。

## Interactions
- `DailyLog` コンポーネントに属します。
