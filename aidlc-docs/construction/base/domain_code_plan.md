# ドメインモデル実装計画

このドキュメントは、`aidlc-docs/construction/service_configuration` に記載されたドメインモデルのKotlinによる実装計画を記述します。

## 実装ステップ

- [ ] **ステップ1: `DeliveryService` エンティティの実装**
    - `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/DeliveryService.kt` を作成する。
    - ドキュメントに基づき、`serviceId`, `serviceName`, `isPreset`, `memo` のプロパティを持つデータクラスを定義する。

- [ ] **ステップ2: `DeliveryService` のインメモリリポジトリの実装**
    - `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/DeliveryServiceRepository.kt` を作成する。
    - `findAll`, `findById`, `save`, `delete` の基本的なCRUD操作を持つインターフェースを定義する。
    - インメモリでデータを保持する実装クラスを作成する。

- [ ] **ステップ3: `PaymentCycle` エンティティの実装**
    - `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/PaymentCycle.kt` を作成する。
    - `CycleType` や曜日の `Enum` を定義する。
    - ドキュメントに基づき、`cycleType` に応じたプロパティを持つデータクラスを定義する。

- [ ] **ステップ4: `PaymentCycle` のインメモリリポジトリの実装**
    - `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/PaymentCycleRepository.kt` を作成する。
    - `findByDeliveryServiceId`, `save` の操作を持つインターフェースを定義する。
    - インメモリでデータを保持する実装クラスを作成する。

- [ ] **ステップ5: `HolidayService` インターフェースの実装**
    - `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/HolidayService.kt` を作成する。
    - `isHoliday(date: LocalDate): Boolean` メソッドを持つインターフェースを定義する。
    - 標準ライブラリや外部ライブラリは利用せず、土日のみを休日と判定するシンプルなインメモリ実装を作成する。

- [ ] **ステップ6: `PaymentDateCalculator` ドメインサービスの実装**
    - `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/PaymentDateCalculator.kt` を作成する。
    - `HolidayService` を利用して、次回の入金予定日を計算するロジックを実装する。

- [ ] **ステップ7: 全体レビュー**
    - 全ての実装がドキュメントの要求を満たしているかレビューする。

## 確認事項

[Question] ディレクトリ構造はフラットに、とありますが、ドメインモデルのクラスは `app/unit1-service-configuration/src/main/kotlin/com/example/serviceconfiguration/domain/` のようなドメイン層のパッケージにまとめて配置する形でよろしいでしょうか？あるいは、`com/example/serviceconfiguration` 直下にすべてのクラスを配置しますか？
[Answer] 

[Question] ログやその他のユーティリティには、利用可能な標準的なコンポーネントを再利用してください、とありますが、現時点ではSpring Boot標準のロギング（Logback）を利用する想定でよろしいでしょうか？
[Answer] 

[Question] リポジトリはインメモリであると想定してください、とありますが、アプリケーション起動時にプリセットデータをリポジトリに初期登録する実装は必要ですか？
[Answer] 

計画を作成しましたので、レビューと承認をお願いします。承認後、ステップ1から順に実行します。
