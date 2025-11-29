# DeliveryService Component

`DeliveryService` は、配達員が利用するデリバリーサービスを表すエンティティです。

## Attributes

| Name | Type | Description | Constraints |
| --- | --- | --- | --- |
| `serviceId` | UUID | サービスを一意に識別するID | Primary Key, Not Null |
| `serviceName` | String | サービスの名称 | Not Null, Unique |
| `isPreset` | Boolean | プリセットとして提供されているサービスかを示すフラグ | Not Null |
| `memo` | String | ユーザーが任意で入力できるメモ | Nullable |

## Behavior

### `create(serviceName, isPreset, memo)`
- 新しいデリバリーサービスを登録します。
- プリセットから追加する場合は `isPreset` を `true` に設定します。
- 手動で追加する場合は `isPreset` を `false` に設定します。

### `update(serviceId, serviceName, memo)`
- 既存のデリバリーサービスの情報を更新します。
- `serviceName` と `memo` のみが変更可能です。

### `delete(serviceId)`
- 登録済みのデリバリーサービスを削除します。

## Preset Data

以下のサービスがプリセットデータとして初期登録されています。ユーザーはこれらを有効化して利用開始できます。

- UberEats
- 出前館
- Wolt
- RocketNow
- Amazon Flex
- menu
- ピックゴー
