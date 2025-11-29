# PaymentDateCalculator Component

`PaymentDateCalculator` は、指定された締め日と支払いサイクルに基づき、次回の入金予定日を計算するドメインサービスです。

## Behavior

### `calculateNextPaymentDate(cutoffDate, paymentCycle)`
- **Input:**
  - `cutoffDate` (Date): 計算の基準となる締め日。
  - `paymentCycle` (PaymentCycle): 計算に使用する支払いサイクルの定義。
- **Output:**
  - `paymentDate` (Date): 計算された次回の入金予定日。
- **Logic:**
  1. `paymentCycle` の `cycleType` に基づいて、基本的な支払日を算出します。
  2. `HolidayService` (後述) を利用して、算出した支払日が日本の土日祝日に該当するかを判定します。
  3. 支払日が土日祝日の場合、翌営業日に日付を調整します。
  4. 最終的な入金予定日を返します。

## Dependencies

### `HolidayService` (Interface)
- `PaymentDateCalculator` が依存する、祝日判定のためのインターフェースです。
- このインターフェースの実装は、外部の祝日API（例: Google Calendar API）と通信し、指定された日付が祝日かどうかを判定します。

#### Interface Definition
- `isHoliday(date)`:
  - **Input:** `date` (Date)
  - **Output:** `isHoliday` (Boolean)
