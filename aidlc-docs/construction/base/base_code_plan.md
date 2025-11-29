# ベースコード実装計画

このドキュメントは、`aidlc-docs/construction/base/` にあるドキュメント群に基づいたベースコードの実装計画を定義します。

## 実装ステップ

- [ ] **1. `app` 開発ディレクトリの作成**
    - [ ] a. ルートに `app` ディレクトリを作成する。以降の作業はこのディレクトリ内で行う。

- [ ] **2. Gradleマルチプロジェクトのセットアップ**
    - [ ] a. `app` ディレクトリに `build.gradle.kts` と `settings.gradle.kts` を作成する。
    - [ ] b. `settings.gradle.kts` に `core` および `unit1` から `unit5` までの全モジュールをインクルードする。
    - [ ] c. `app` ディレクトリの `build.gradle.kts` に、SpringBoot、Kotlin、および共通の依存関係（JUnit, Mockitoなど）を設定する。
    - [ ] d. Gradle Wrapperを `app` ディレクトリに生成する。

- [ ] **3. モジュール構造の作成**
    - [ ] a. `directory_structure.md` に基づき、`app` ディレクトリ内に `core`, `unit1` から `unit5` までのディレクトリ構造を作成する。
    - [ ] b. 各モジュールに空の `build.gradle.kts` を配置する。
    - [ ] c. 各サービスモジュール (`unit1`〜`unit5`) の `build.gradle.kts` に `core` モジュールへの依存 (`implementation(project(":core"))`) を追加する。

- [ ] **4. 静的解析ツールの導入**
    - [ ] a. `app` ディレクトリの `build.gradle.kts` に `ktlint` と `detekt` のGradleプラグインを追加し、設定を行う。
    - [ ] b. すべてのサブモジュールにプラグインが適用されるように設定する。

- [ ] **5. SpringBootアプリケーションの基本実装**
    - [ ] a. `app/unit1-service-configuration` モジュールに、アプリケーションのエントリーポイントとなる `ServiceConfigurationApplication.kt` を作成する。
    - [ ] b. 同モジュールに、動作確認用の簡単な `HealthCheckController` を作成する (`/health` エンドポイントなど)。
    - [ ] c. `src/main/resources` に `application.properties` を作成する。

- [ ] **6. API定義 (OpenAPI) のセットアップ**
    - [ ] a. `app` ディレクトリの `build.gradle.kts` に `springdoc-openapi-starter-webmvc-ui` の依存関係を追加する。
    - [ ] b. アプリケーションを起動し、`/swagger-ui/index.html` にアクセスしてAPIドキュメントが表示されることを確認する。

- [ ] **7. Docker環境の構築**
    - [ ] a. `app` ディレクトリに `docker` ディレクトリを作成する。
    - [ ] b. SpringBootアプリケーションをビルドし、実行するための `Dockerfile` を `app` ディレクトリに作成する。
    - [ ] c. アプリケーションと、将来的に追加されるデータベースやPrismモックサーバーを起動するための `docker-compose.yml` の雛形を `app` ディレクトリに作成する。

- [ ] **8. CI (GitHub Actions) のセットアップ**
    - [ ] a. ルートに `.github/workflows` ディレクトリを作成する。
    - [ ] b. プルリクエスト時に、`app` ディレクトリに移動してから、ビルド (`./gradlew build`)、テスト (`./gradlew test`)、静的解析 (`./gradlew ktlintCheck`, `./gradlew detekt`) を実行するGitHub Actionsワークフローファイル (`ci.yml`) を作成する。
