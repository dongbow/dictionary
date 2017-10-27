# AntDesign & Flux 项目模板

## 环境需求

```
nodejs >= 4
```

## 安装包依赖

推荐使用cnpm来解决依赖包下载慢的问题，安装cnpm:

```
(sudo) npm install cnpm -g
```

安装项目的依赖包：
```
cnpm install -d
```

## 开发模式启动运行

```
npm run start
```

访问 http://127.0.0.1:8989

## 编译代码

具体编译后位置可以在package.json的script节点中修改build属性来指定。

```
npm run build
```

## 相关约定

#### 1. 本地模块导出与引入
包路径别名已经在webpack的配置中指定，当前有以下几个大的路径：
```
'bases': path.resolve(__dirname,'./src/flux/base'),          //alt.js 实例所在位置
'actions': path.resolve(__dirname, './src/flux/actions'),    //action 位置
'stores': path.resolve(__dirname,'./src/flux/stores'),       //store 位置
'components': path.resolve(__dirname, './src/components'),   //组件位置
'services': path.resolve(__dirname, './src/services'),       //相关辅助函数所在位置
```
尽量不要在代码中写'../flux/action/Test.js'这种风格的引入，避免以后文件移动引起包路径加载错误的问题。

