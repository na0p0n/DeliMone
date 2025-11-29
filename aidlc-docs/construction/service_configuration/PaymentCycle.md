# PaymentCycle Component

`PaymentCycle` は、各デリバリーサービスの支払いサイクルを定義するエンティティです。`DeliveryService` と1対1の関係を持ちます。

## Attributes

| Name | Type | Description | Constraints |
| --- | --- | --- | --- |
| `paymentCycleId` | UUID | 支払いサイクルを一意に識別するID | Primary Key, Not Null |
| `deliveryServiceId` | UUID | 関連する `DeliveryService` のID | Foreign Key, Not Null, Unique |
| `cycleType` | Enum | 支払いサイクルの種別 | Not Null (`WEEKLY`, `BI_MONTHLY`, `MANUAL`) |

---

### `WEEKLY` (週払い) の場合

| Name | Type | Description | Example |
| --- | --- | --- | --- |
| `cutoffDayOfWeek` | Enum | 締め日の曜日 | `WEDNESDAY` |
| `paymentDayOfWeek` | Enum | 支払日の曜日 | `FRIDAY` |
| `paymentWeek` | Enum | 支払いの週 | `NEXT_WEEK` |

### `BI_MONTHLY` (月2回払い) の場合

月2回の支払いルールを2つのセットで定義します。

**First Cycle**
| Name | Type | Description | Example |
| --- | --- | --- | --- |
| `firstCutoffDay` | Integer | 1回目の締め日 (1-31, 99は末日) | `15` |
| `firstPaymentDay` | Integer | 1回目の支払日 (1-31) | `25` |
| `firstPaymentMonthOffset` | Integer | 支払月（0: 同月, 1: 翌月） | `0` |
| `isFirstDateBusinessDay` | Boolean | 締め日/支払日を営業日で指定するか | `false` |

**Second Cycle**
| Name | Type | Description | Example |
| --- | --- | --- | --- |
| `secondCutoffDay` | Integer | 2回目の締め日 (1-31, 99は末日) | `99` (末日) |
| `secondPaymentDay` | Integer | 2回目の支払日 (1-31) | `10` |
| `secondPaymentMonthOffset`| Integer | 支払月（0: 同月, 1: 翌月） | `1` (翌月) |
| `isSecondDateBusinessDay` | Boolean | 締め日/支払日を営業日で指定するか | `false` |

---

## Behavior

### `set(deliveryServiceId, cycleDetails)`
- 指定された `DeliveryService` に支払いサイクルを設定または更新します。
- `cycleDetails` には、`cycleType` に応じた属性が含まれます。
