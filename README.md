# android studio project use maven
An Android gradle use Maven local repository

## android studio 使用本地maven私服优势所在
<p>好了，下面说中文。</p>
<p>是不是觉得android studio 中gradle 的引用方式 compile 'xxx' 很方便的样子？</p>
<p>在企业中，各个不同的人写不同的模块，有写库的，有写公共JAR的，有写业务逻辑的，写业务逻辑的可能就需要
使用公司其他同事维护的库了，这时要是我们能以compile 'xxx' 方式引入岂不是很爽？</p>
<p>而且写库文件的同事更新程序后，你也不必很苦恼的重新导他的库了或者重新编译他的库，这看你的引用方式咯。你只需要修改compile的
中所带的版本号到他的版本号就可以了，是不是简单到粗暴？</p>

** 我们完全可以做到这样！**
<p>好，那下面就一起来实现这样的，看完本篇README和下载本工程代码，也许你就会了。</p>
<p>当然，有些配置你得替换的，如果不知道，mailto me: ouyangfan1991@gmail.com <ouyangfan1991@gmail.com> </p>

## 工程说明：
1. 该工程是一个在android studio的gradle中maven的测试工程；
2. 主要是为了测试maven企业私服环境是否搭建成功；
3. 测试android studio使用本地私服上传下载maven控件；
   build.gradle以compile 'groupId:artifactId:version' 形式依赖；
4. 虽然在本程序中，utillibrary是以Module的形式与app Module放在同一个工程下的，
但是在app Module中并不是以compile project形式引入的，而是以说明3中的方式引入的。

### 环境搭建

1. maven私服使用Nexus oss管理，关于Nexus oss搭建请参照
+ [建立企业内部Maven服务器并使用Android Studio发布公共项目](http://www.linuxidc.com/Linux/2015-06/118878.htm) 
+  [nexus-2.12.0安装与部署](http://blog.csdn.net/yccn214/article/details/50527490)；
2. 本工程在linux 环境下部署成功。

### android studio上传maven私服

上面搭建成功后，就可以使用android studio来管理了。

1. 配置
具体的可以参照工程中common.gradle , user.properties 以及utillibrary/gradle.properties 中的配置
配置注意点：

   + common.gradle中
      + 需要申明apply plugin: 'maven' 为maven 不然找不到mavenDeployer函数
      + user.properties 里面对应的 repository.url 必须与 pom.project 中申明的 version(在各个工程配置里的gradle.properties文件)匹配。release必须为release的url, snapshots 必须为 snapshots的url,所以两个文件中，这个地方需要匹配。不然传不上去。必须匹配，不能用Group 的url，因为Group的一般只配置view只读权限，只提供预览release和snapshots里面的库，并且可以提供下载(包括中央工程的代理)。

   + maven的settings.xml中
      + mirror、profile、activeProfile、server 的配置

2. 发布到私服
我们在common.gradle已经配置上传task了，接下来就在需要上传的库工程utillibrary的build.gradle中apply from 引用。
然后我们就可以通过gradle uploadArchives 来将库上传私服了。

### android studio 引用 maven 私服中的库

1. 工程路径下的build.gradle中
将jcenter()仓库地址换成本地mavenLocal()和私服maven { url "http://你企业服务器地址:8081/nexus/content/groups/android_public/"} 仓库

2. 在app/build.gradle中
引用你刚刚发布到私服中的库，compile 'com.xtc.ouyangfan:utilLib:0.0.1',
好了， 重新build一下吧，你可以使用了。
