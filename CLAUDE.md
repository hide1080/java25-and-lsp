# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 概要

Java 25 上で動く最小構成の Spring Boot 4.1（Spring MVC）アプリケーション。ビルドは Gradle 9（wrapper）。Java 25 と LSP（jdtls）を Claude Code と組み合わせて動作確認するためのサンドボックスで、`.claude/settings.json` で `jdtls-lsp@claude-plugins-official` プラグインが有効になっている。Java ソースの定義ジャンプや診断には LSP ツールを優先して使うこと。

## コマンド

```bash
./gradlew build                     # コンパイル + テスト + パッケージング
./gradlew bootRun                   # アプリ起動（デフォルトポート 8080、GET /hello）
./gradlew test                      # 全テスト実行（JUnit 5）
./gradlew test --tests 'com.example.java25lsp.Java25AndLspApplicationTests'            # クラス単位
./gradlew test --tests 'com.example.java25lsp.Java25AndLspApplicationTests.contextLoads' # メソッド単位
./gradlew clean
```

linter / formatter は設定されていない。

## 構成メモ

- ベースパッケージは `com.example.java25lsp`。起動クラス `Java25AndLspApplication` は `@SpringBootApplication` と `@RestController` を兼ねており、`/hello` エンドポイントを直接持っている。新しいコンポーネントはコンポーネントスキャンの対象になるよう、このパッケージかそのサブパッケージに置くこと。
- Java ツールチェーンは `build.gradle` で 25 に固定されている。実行環境は WSL2。
- Spring Boot 4 ではスターターがモジュール化されている。Web は `spring-boot-starter-webmvc`、テストは `spring-boot-starter-webmvc-test` を使う（Boot 3 の `spring-boot-starter-web` / `spring-boot-starter-test` ではない）。
- ソースのインデントはタブ。
- `bin/`, `.classpath`, `.project`, `.settings/` は Eclipse / jdtls が生成するファイルで、gitignore 対象。
