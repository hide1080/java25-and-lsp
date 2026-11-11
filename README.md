# java25-and-lsp

Java 25 + Spring Boot の最小構成プロジェクトで、Claude Code から Java の LSP（jdtls）を使えるようにしたサンドボックス。

## バージョン

| 項目 | バージョン |
| --- | --- |
| Java | 25（Gradle toolchain で固定） |
| Spring Boot | 4.1.2 |
| Gradle | 9.8.2（wrapper） |

## Claude Code での LSP 利用

`.claude/settings.json` で `jdtls-lsp@claude-plugins-official` プラグインを有効にしており、Claude Code が Java の LSP（hover、定義ジャンプ、診断など）を使える。

```json
{
  "enabledPlugins": {
    "jdtls-lsp@claude-plugins-official": true
  }
}
```

### セットアップの経緯

Claude Code に次のように指示し、Claude 自身が LSP のインストールと設定を行った。

```
このプロジェクトで Java の LSP を使えるようにして
```

### 動作確認

次のように指示して hover を試した。

```
LSP で Java25AndLspApplication の hover を試して
```

出力結果:

```
  Read 1 file

● LSP(operation: "hover", symbol: "Java25AndLspApplication", in: "src/main/java/com/example/java25lsp/Java25AndLspApplication.java")
Hover info available

Java25AndLspApplication クラス（10行目）への LSP hover は成功しました。

結果
com.example.java25lsp.Java25AndLspApplication
Source: java25-and-lsp (Java25AndLspApplication.java#10)
```

## 実行方法

```bash
./gradlew bootRun     # http://localhost:8080/hello
./gradlew test
```
