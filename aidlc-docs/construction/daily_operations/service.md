# Service Component

`Service` コンポーнентは、配達サービスの種類を表すエンティティです。

## Attributes

| Name | Type | Description |
|---|---|---|
| id | UUID | 一意な識別子 |
| name | String | サービス名（例：Uber Eats, 出前館）|

## Interactions
- `Delivery` コンポーネントから参照されます。
