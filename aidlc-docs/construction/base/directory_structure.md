# ディレクトリ構造

このドキュメントでは、プロジェクトの基本的なディレクトリ構造を定義します。

```
/
|-- .github/                # CI/CDワークフロー (例: GitHub Actions)
|-- aidlc-docs/             # プロジェクトドキュメント
|-- docker/                 # Docker関連ファイル (Dockerfile, docker-compose.yml)
|-- unit1-service-configuration/ # Unit 1 モジュール
|   |-- src/main/kotlin/
|   |-- build.gradle.kts
|-- unit2-daily-operations/     # Unit 2 モジュール
|   |-- src/main/kotlin/
|   |-- build.gradle.kts
|-- unit3-cash-flow-management/ # Unit 3 モジュール
|   |-- src/main/kotlin/
|   |-- build.gradle.kts
|-- unit4-analytics-and-reporting/ # Unit 4 モジュール
|   |-- src/main/kotlin/
|   |-- build.gradle.kts
|-- unit5-non-functional-requirements/ # Unit 5 (PWAフロントエンド) モジュール
|   |-- src/main/kotlin/ # バックエンドサポート
|   |-- src/main/resources/static/ # フロントエンドリソース
|   |-- build.gradle.kts
|-- core/                     # 共有モジュール
|   |-- src/main/kotlin/
|   |-- build.gradle.kts
|-- gradlew                 # Gradleラッパー
|-- gradlew.bat
|-- gradle/
|   |-- wrapper/
|       |-- gradle-wrapper.jar
|       |-- gradle-wrapper.properties
|-- build.gradle.kts        # ルートビルドスクリプト
|-- settings.gradle.kts     # マルチプロジェクト設定
```

## 説明

- **マルチプロジェクト構成**: 各作業ユニットを独立したGradleモジュールとして管理します。これにより、各チームは並行して開発を進めやすくなります。
- **`core/`**: `interface_plan.md`で定義されたDTOなど、ユニット間で共有されるコードを配置する共通モジュールです。
- **`docker/`**: 開発環境および本番環境用のDocker設定を配置します。
- **ルートファイル**: Gradleラッパーと、プロジェクト全体を管理する `build.gradle.kts`, `settings.gradle.kts` を配置します。
