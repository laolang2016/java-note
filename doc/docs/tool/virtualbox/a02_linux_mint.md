# linux mint

## 下载与安装

### 下载地址

[https://www.linuxmint.com/download_all.php](https://www.linuxmint.com/download_all.php)

当前使用版为 **`22`** , 下载地址: [https://www.linuxmint.com/edition.php?id=316](https://www.linuxmint.com/edition.php?id=316)

### 设置网络

第一个网卡选择 `网络地址转换(NAT)` , 第二个网卡选择 `仅主机(Host-Only)网络`

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/001.png)
</figure>

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/002.png)
</figure>

### 测试网络

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/003.png)
</figure>

## 安装增强工具

菜单 设备 -> 安装增强功能

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/004.png)
</figure>

稍等几秒会弹出对话框, 然后直接点击运行

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/005.png)
</figure>

看到如下提示说明安装成功, 回车后关闭虚拟机

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/006.png)
</figure>

重启后可以通过菜单 视图 -> 自动调整窗口大小 使窗口宽高自适应, 点击该菜单后虚拟机窗口可能会缩小, 再点击最大化即可自适应

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/009.png)
</figure>

粘贴板默认不共享, 可通过菜单 设备 -> 共享粘贴板 设置

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/010.png)
</figure>


## 共享文件夹

建议勾选自动挂载

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/007.png)
</figure>

此时进入虚拟机会发现共享文件夹没有访问权限, 执行如下命令并重启即可

```shell
sudo usermod -a -G vboxsf ${USER}
```


可以使用如下命令在当前目录创建一个软连接

```shell
ln -s /media/sf_share/ ~/share
```

在共享目录添加文件后可以在虚拟机中看到, 但是默认具有可执行权限,需要手动去除

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/008.png)
</figure>

## 一些基本配置


### vim 基本配置

> ~/.vimrc

```
" 开启语法高亮
syntax enable

" 开启语法高亮
syntax on

" 设置字体
set guifont=Monaco\ 12

" 检测文件类型
filetype on

" " 针对不同的文件，采用不同的缩进方式
filetype indent on

" 设置取消备份，禁止临时文件生成
set nobackup
set noswapfile

" 显示当前行号和列号
set ruler

" 在状态栏显示正在输入的命令
set showcmd

" 左下角显示当前Vim模式
set showmode

" 显示状态栏
set laststatus=2

" 显示行号
set number

" 开启及时搜索(is)
set incsearch

" 设置搜索高亮(hlsearch)
set hls

" 设置搜索时忽略大小写
set ignorecase
```

### 命令行基本配置

> ~/.bashrc

```
# ls 命令
alias ll='ls -alFh --time-style="+%Y-%m-%d %H:%M:%S"'
alias la='ls -A'
alias l='ls -lFh --time-style="+%Y-%m-%d %H:%M:%S"'

# bash ps1
export PS1='\033[1;32m\u@\H\033[0m:\033[1;34m\W\$\033[0m '
```

整体效果如下

```
laolang@laolang-pc:~$ l
总计 32K
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 公共/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 模板/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 视频/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 图片/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 文档/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 下载/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 音乐/
drwxr-xr-x 2 laolang laolang 4.0K 2025-07-04 11:50:29 桌面/
lrwxrwxrwx 1 laolang laolang   16 2025-07-04 12:05:51 share -> /media/sf_share//
laolang@laolang-pc:~$ cd share
laolang@laolang-pc:share$ pwd
/home/laolang/share
laolang@laolang-pc:share$ 
```

### 安装字体

jetbrains 字体下载地址 [https://www.jetbrains.com/lp/mono/](https://www.jetbrains.com/lp/mono/)

解压后将所有的 `ttf` 字体放到 `~/.local/share/fonts/jetbrans/ttf/` , 然后执行如下命令即可

```
fc-cache -f -v ~/.local/share/fonts/jetbrans/ttf/
```

### 输入法

#### 安装

`ibus` 的安装与配置更加简单, 并且基本上是够用了

执行如下命令安装 `ibus` 输入法

```
sudo apt-get install ibus ibus-libpinyin
```

#### 激活

点击左下角菜单选择 `输入法`

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/011.png)
</figure>

选择 `ibus`

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/012.png)
</figure>

注销并重新登陆即可

#### 配置

重新登录后再状态栏最右边右键左下角输入法图标(默认为英文输入法, 即为一个 `键盘` 图标)

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/014.png)
</figure>

常规设置建议删除切换下一输入法的快捷键, 其他随意

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/015.png)
</figure>

输入法设置建议删除其他输入法只保留中文输入法

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/016.png)
</figure>

输入法设置中选中输入法后点击首选项或者在输入法状态栏中点击最右边的按钮都可以打开输入法的设置对话框

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/017.png)
</figure>

#### 效果

效果如下

<figure markdown="span">
  ![](/java-note/assets/images/tool/virtualbox/a02_linux_mint/018.png)
</figure>


### 卸载 libreoffice

```bash
# 卸载LibreOffice及其所有组件
sudo apt remove --purge libreoffice*
# 清理不再需要的依赖
sudo apt autoremove
# 清理可能残留的配置文件
sudo apt clean
```

### pip3

`ubuntu` 系列内置了 `python2` 和 `python3` , 但是没有 `pip3`

```bash
# 安装 pip3
sudo apt-get install python3-pip
```

此时 `pip3` 暂无法使用, 报错如下

```
laolang@mint-cpp:~$ pip3 install virtualenv
error: externally-managed-environment

× This environment is externally managed
╰─> To install Python packages system-wide, try apt install
    python3-xyz, where xyz is the package you are trying to
    install.
    
    If you wish to install a non-Debian-packaged Python package,
    create a virtual environment using python3 -m venv path/to/venv.
    Then use path/to/venv/bin/python and path/to/venv/bin/pip. Make
    sure you have python3-full installed.
    
    If you wish to install a non-Debian packaged Python application,
    it may be easiest to use pipx install xyz, which will manage a
    virtual environment for you. Make sure you have pipx installed.
    
    See /usr/share/doc/python3.12/README.venv for more information.

note: If you believe this is a mistake, please contact your Python installation or OS distribution provider. You can override this, at the risk of breaking your Python installation or OS, by passing --break-system-packages.
hint: See PEP 668 for the detailed specification.
laolang@mint-cpp:~$
```

解决方法参考: [新版ubuntu使用pip时发生的错误](https://www.cnblogs.com/clark1990/p/17942952)

```bash
sudo mv /usr/lib/python3.x/EXTERNALLY-MANAGED /usr/lib/python3.x/EXTERNALLY-MANAGED.bk
```