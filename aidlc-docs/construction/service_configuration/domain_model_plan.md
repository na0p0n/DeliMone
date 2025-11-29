# ドメインモデル設計計画

このドキュメントは、Unit 1: サービス設定のユーザーストーリーを実装するためのドメインモデル設計の計画を記述します。

## 設計ステップ

- [x] **ステップ1: ユーザーストーリーの分析と主要コンポーネントの特定**
  - `unit1_service_configuration.md` を分析し、ドメインの関心事を明確にする。
  - 主要なドメインコンポーネント（エンティティ、値オブジェクト）として `DeliveryService` と `PaymentCycle` を洗い出す。
  - 入金日計算ロジックのための `PaymentDateCalculator` サービスを特定する。

- [x] **ステップ2: `DeliveryService` コンポーネントの設計**
  - 属性（サービスID, サービス名, プリセットかどうか）を定義する。
  - 振る舞い（作成, 編集, 削除）を定義する。
  - プリセットデータ（UberEats, 出前館など）の扱いについて定義する。
  - 設計内容を `aidlc-docs/construction/service_configuration/DeliveryService.md` に記述する。

- [x] **ステップ3: `PaymentCycle` コンポーネントの設計**
  - 属性（支払いサイクルID, サイクル種別(週払い, 月2回払い, 手動), 締め日ルール, 支払日ルール, 営業日考慮フラグ）を定義する。
  - 振る舞い（設定, 変更）を定義する。
  - `DeliveryService` との関連（1対1）を定義する。
  - 設計内容を `aidlc-docs/construction/service_configuration/PaymentCycle.md` に記述する。

- [x] **ステップ4: `PaymentDateCalculator` コンポーネントの設計**
  - 振る舞い（`calculateNextPaymentDate(cutoffDate, paymentCycle)`）を定義する。
  - 祝日判定ロジックと、外部APIとの連携（インターフェース）を定義する。
  - 支払日が土日祝日の場合の調整ロジックを定義する。
  - 設計内容を `aidlc-docs/construction/service_configuration/PaymentDateCalculator.md` に記述する。

- [x] **ステップ5: 全体レビュー**
  - 全てのドキュメントがユーザーストーリーの要求を満たしているかレビューする。

## 確認事項

[Question] 祝日APIとして、Google Calendar APIが例として挙げられていますが、具体的なAPIエンドポイントや認証方法について指定はありますか？もしなければ、一般的なREST APIを想定して設計を進めて良いですか？
[Answer] 具体的な指定はありません、一般的なREST APIを想定して設計を進めてください。
