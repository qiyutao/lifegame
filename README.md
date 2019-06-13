# lifegame

该项目实现生命游戏基于java swing，并打包为Docker容器（容器无gui界面）。
master分支上为java swing版本；docker分支上为Docker版本。

## 环境
Java版本：1.8
maven版本：3.6.1

## 启动方法

源代码启动：
  启动类文件在：Start.Main

Docker启动：
  1.打包镜像： 
    docker build -t lifegame:v3 .
  2.运行镜像： 
    docker run -it lifegame:v3 sh start.sh 
  详见DockerFile
  
## 游戏操作方法 
打开界面之后，可以选择‘预制图形与速度’

游戏运行操作：
  滚轮操作：可以放大缩小细胞大小
  空格：暂停
  c：加速
  x：减速
  z：回复到正常速
