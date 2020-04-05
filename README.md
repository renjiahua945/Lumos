<h1 align="center"><a href="https://github.com/renjiahua945/blog" target="_blank">Lumos</a></h1>

> Lumos是基于Spring Boot的轻量级博客，是学习搭建使用Spring Boot的不错选择。

<p align="center">
<a href="https://github.com/renjiahua945/blog/releases"><img alt="GitHub release" src="https://img.shields.io/github/release/renjiahua945/Lumos"/></a>
<a href="https://github.com/renjiahua945/Lumos/releases"><img alt="GitHub All Releases" src="https://img.shields.io/github/downloads/renjiahua945/Lumos/total"/></a>
<a href="https://github.com/renjiahua945/Lumos/commits"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/renjiahua945/Lumos"/></a>
<a href="https://github.com/renjiahua945/Lumos/packages"><img alt="Travis CI" src="https://img.shields.io/github/repo-size/renjiahua945/Lumos"/></a>

</p>

------------------------------

## 简介

**Lumos** `[ˈlumos]`，音译为撸莫斯，意为荧光闪烁。撸当然是撸代码了，莫斯是流浪地球的人工智能，所以Lumos解释为撸出一个像莫斯一样的人工智能。除此之外，Lumos是哈利波特中的一句咒语，可以将魔法杖点着火用来照明。这是一个轻量级博客，值得尝试一下。


## 声明

> 本项目为使用Apache 2.0证书的开源博客项目，大家可以下载代码学习和使用，但是需要尽量遵守开源协议。博客现在还处于快速迭代更新的进程中，难免有些问题，如果发现问题，最好在GitHub上提交issues。


> 目前我们的release分支即 master，肯定会有很多小问题，不要运行不起来就跑过来吐槽什么代码开源不完整之类的，多找找自己的原因。同时建议下载最新 release 版本的代码。

## 快速开始

### 拉取最新的Lumos代码

```bash
git clone https://github.com/renjiahua945/Lumos.git
```

或者


直接在项目上点击download zip


### 启动 Lumos

1. 执行项目中SQL文件，创建表。

2. 修改Application.yml中的MySQL数据库信息、Redis数据库信息、Java Mail数据库配置信息。具体如何修改，可以在yml文件的注释中查看。
3. 项目中设计了敏感词校验，使用的百度云的文本校验接口，如果您想使用该项功能，需要去百度云创建应用，申请到AppId，Secret Key和ApiToken。代码在AipContentCensorBuilder.java文件中。```new AipContentCensor("434343", "RQERNWNRN", "FSFSMFSMFMSFMM");```

4. 如果以上步骤都完成了，可以构建下项目，看下有没有报错。
5. 后台密码没有提供注册界面，需要自己使用项目中的MD5方法，自行生成密码存在数据库。生成方法在：MD5Util.java中```public static String md5Encode(String origin, String charsetname)```

## 博客示例

请移步： <a href="https://www.javafan.club">点击进入Lumos</a>
##Lumos交流群
Lumos交流学习群：
<a href="https://jq.qq.com/?_wv=1027&k=5Xi9tmg">点击加入群聊</a>

## 许可证

[![license](https://img.shields.io/badge/license-Apache%202.0-green)](https://github.com/renjiahua945/Lumos/blob/master/LICENSE)

> Lumos 使用 Apache-v2.0 协议开源，请尽量遵守开源协议。

## 捐赠

> 如果 Lumos对你有帮助，可以请我喝杯咖啡。你的支持就是我最大的动力
>  
<img src="https://i.imgur.com/1HdZ3sw.jpg" width = "200" height = "300" alt="微信收款码" align=center />

## 预览图
![](https://i.imgur.com/SRKMPUw.png)
![](https://i.imgur.com/VlBA9Vo.png)
![](https://i.imgur.com/lvGV7Nj.png)
![](https://i.imgur.com/4XNhlsN.png)
![](https://i.imgur.com/aOxjym5.png)
![](https://i.imgur.com/iEfoDzk.png)
![](https://i.imgur.com/HvoFIx5.png)
![](https://i.imgur.com/FQrelUW.png)
![](https://i.imgur.com/voFA2EL.png)