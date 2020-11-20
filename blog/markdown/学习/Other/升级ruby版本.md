# 升级ruby版本

升级ruby版本，有时候安装ruby的版本过低，需要进行升级，例如安装在centos6.7安装fpm需要ruby版本在1.9以上。

1、主机环境如下：

```shell
1 [root@test ~]# cat /etc/redhat-release 
2 CentOS release 6.7 (Final)
3 [root@test ~]# uname -r
4 2.6.32-573.el6.x86_64
```

2、使用yum安装ruby

```shell
 1 [root@web ~]# yum install rubygems ruby-devel               
 2 Loaded plugins: fastestmirror, security
 3 Setting up Install Process
 4 base                                                                                                   | 3.7 kB     00:00     
 5 base/primary_db                                                                                        | 4.7 MB     00:02     
 6 extras                                                                                                 | 3.4 kB     00:00     
 7 extras/primary_db                                                                                      |  30 kB     00:00     
 8 updates                                                                                                | 3.4 kB     00:00     
 9 updates/primary_db                                                                                     | 8.1 MB     00:01     
10 Resolving Dependencies
11 --> Running transaction check
12 ---> Package ruby-devel.x86_64 0:1.8.7.374-5.el6 will be installed
13 --> Processing Dependency: ruby-libs = 1.8.7.374-5.el6 for package: ruby-devel-1.8.7.374-5.el6.x86_64
14 --> Processing Dependency: libruby.so.1.8()(64bit) for package: ruby-devel-1.8.7.374-5.el6.x86_64
15 ---> Package rubygems.noarch 0:1.3.7-5.el6 will be installed
16 --> Processing Dependency: ruby-rdoc for package: rubygems-1.3.7-5.el6.noarch
17 --> Processing Dependency: /usr/bin/ruby for package: rubygems-1.3.7-5.el6.noarch
18 --> Running transaction check
19 ---> Package ruby.x86_64 0:1.8.7.374-5.el6 will be installed
20 ---> Package ruby-libs.x86_64 0:1.8.7.374-5.el6 will be installed
21 ---> Package ruby-rdoc.x86_64 0:1.8.7.374-5.el6 will be installed
22 --> Processing Dependency: ruby-irb = 1.8.7.374-5.el6 for package: ruby-rdoc-1.8.7.374-5.el6.x86_64
23 --> Running transaction check
24 ---> Package ruby-irb.x86_64 0:1.8.7.374-5.el6 will be installed
25 --> Finished Dependency Resolution
26 
27 Dependencies Resolved
28 
29 ==============================================================================================================================
30  Package                        Arch                       Version                             Repository                Size
31 ==============================================================================================================================
32 Installing:
33  ruby-devel                     x86_64                     1.8.7.374-5.el6                     base                     318 k
34  rubygems                       noarch                     1.3.7-5.el6                         base                     207 k
35 Installing for dependencies:
36  ruby                           x86_64                     1.8.7.374-5.el6                     base                     538 k
37  ruby-irb                       x86_64                     1.8.7.374-5.el6                     base                     318 k
38  ruby-libs                      x86_64                     1.8.7.374-5.el6                     base                     1.7 M
39  ruby-rdoc                      x86_64                     1.8.7.374-5.el6                     base                     381 k
40 
41 Transaction Summary
42 ==============================================================================================================================
43 Install       6 Package(s)
44 
45 Total download size: 3.4 M
46 Installed size: 12 M
47 Is this ok [y/N]: y
48 Downloading Packages:
49 (1/6): ruby-1.8.7.374-5.el6.x86_64.rpm                                                                 | 538 kB     00:00     
50 (2/6): ruby-devel-1.8.7.374-5.el6.x86_64.rpm                                                           | 318 kB     00:00     
51 (3/6): ruby-irb-1.8.7.374-5.el6.x86_64.rpm                                                             | 318 kB     00:00     
52 (4/6): ruby-libs-1.8.7.374-5.el6.x86_64.rpm                                                            | 1.7 MB     00:01     
53 (5/6): ruby-rdoc-1.8.7.374-5.el6.x86_64.rpm                                                            | 381 kB     00:00     
54 (6/6): rubygems-1.3.7-5.el6.noarch.rpm                                                                 | 207 kB     00:00     
55 ------------------------------------------------------------------------------------------------------------------------------
56 Total                                                                                         502 kB/s | 3.4 MB     00:06     
57 warning: rpmts_HdrFromFdno: Header V3 RSA/SHA1 Signature, key ID c105b9de: NOKEY
58 Retrieving key from file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
59 Importing GPG key 0xC105B9DE:
60  Userid : CentOS-6 Key (CentOS 6 Official Signing Key) <centos-6-key@centos.org>
61  Package: centos-release-6-7.el6.centos.12.3.x86_64 (@anaconda-CentOS-201508042137.x86_64/6.7)
62  From   : /etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
63 Is this ok [y/N]: y
64 Running rpm_check_debug
65 Running Transaction Test
66 Transaction Test Succeeded
67 Running Transaction
68   Installing : ruby-libs-1.8.7.374-5.el6.x86_64                                                                           1/6 
69   Installing : ruby-1.8.7.374-5.el6.x86_64                                                                                2/6 
70   Installing : ruby-irb-1.8.7.374-5.el6.x86_64                                                                            3/6 
71   Installing : ruby-rdoc-1.8.7.374-5.el6.x86_64                                                                           4/6 
72   Installing : rubygems-1.3.7-5.el6.noarch                                                                                5/6 
73   Installing : ruby-devel-1.8.7.374-5.el6.x86_64                                                                          6/6 
74   Verifying  : ruby-rdoc-1.8.7.374-5.el6.x86_64                                                                           1/6 
75   Verifying  : ruby-1.8.7.374-5.el6.x86_64                                                                                2/6 
76   Verifying  : rubygems-1.3.7-5.el6.noarch                                                                                3/6 
77   Verifying  : ruby-libs-1.8.7.374-5.el6.x86_64                                                                           4/6 
78   Verifying  : ruby-irb-1.8.7.374-5.el6.x86_64                                                                            5/6 
79   Verifying  : ruby-devel-1.8.7.374-5.el6.x86_64                                                                          6/6 
80 
81 Installed:
82   ruby-devel.x86_64 0:1.8.7.374-5.el6                              rubygems.noarch 0:1.3.7-5.el6                             
83 
84 Dependency Installed:
85   ruby.x86_64 0:1.8.7.374-5.el6             ruby-irb.x86_64 0:1.8.7.374-5.el6        ruby-libs.x86_64 0:1.8.7.374-5.el6       
86   ruby-rdoc.x86_64 0:1.8.7.374-5.el6       
87 
88 Complete!
```

3、查看ruby的版本

```shell
1 [root@web ~]# ruby -v
2 ruby 1.8.7 (2013-06-27 patchlevel 374) [x86_64-linux]
```

4、升级ruby1.9.3版本

1）删除原来的rubygems仓库

```shell
[root@web ~]# gem sources --remove http://rubygems.org/
```

2）添加aliyun的rubygems仓库

```shell
[root@web ~]# gem sources -a http://mirrors.aliyun.com/rubygems/ 
```

3）查看rubygems仓库

```shell
1 [root@web ~]# gem sources -l
2 *** CURRENT SOURCES ***
3 
4 http://mirrors.aliyun.com/rubygems/
```

4）使用RVM进行升级ruby

a:在rvm官方网址：https://rvm.io/执行如下命令：

```shell
1 [root@web ~]#  gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 7D2BAF1CF37B13E2069D6956105BD0E739499BDB
2 gpg: requesting key D39DC0E3 from hkp server keys.gnupg.net
3 gpg: requesting key 39499BDB from hkp server keys.gnupg.net
4 gpg: key D39DC0E3: "Michal Papis (RVM signing) <mpapis@gmail.com>" not changed
5 gpg: key 39499BDB: public key "Piotr Kuczynski <piotr.kuczynski@gmail.com>" imported
6 gpg: no ultimately trusted keys found
7 gpg: Total number processed: 2
8 gpg:               imported: 1  (RSA: 1)
9 gpg:              unchanged: 1
```

b:接着执行如下命令：

```shell
 1 [root@web ~]# \curl -sSL https://get.rvm.io | bash -s stable
 2 Downloading https://github.com/rvm/rvm/archive/1.29.3.tar.gz
 3 curl: (35) SSL connect error
 4 
 5 Could not download 'https://github.com/rvm/rvm/archive/1.29.3.tar.gz'.
 6   curl returned status '35'.
 7 
 8 Downloading https://bitbucket.org/mpapis/rvm/get/1.29.3.tar.gz
 9 Downloading https://bitbucket.org/mpapis/rvm/downloads/1.29.3.tar.gz.asc
10 curl: (7) couldn't connect to host
11 
12 Could not download 'https://bitbucket.org/mpapis/rvm/downloads/1.29.3.tar.gz.asc'.
13   curl returned status '7'.
14 
15 Creating group 'rvm'
16 
17 Installing RVM to /usr/local/rvm/
18 Installation of RVM in /usr/local/rvm/ is almost complete:
19 
20   * First you need to add all users that will be using rvm to 'rvm' group,
21     and logout - login again, anyone using rvm will be operating with `umask u=rwx,g=rwx,o=rx`.
22 
23   * To start using RVM you need to run `source /etc/profile.d/rvm.sh`
24     in all your open shell windows, in rare cases you need to reopen all shell windows.
```

c:执行上述命令 * To start using RVM you need to run `source /etc/profile.d/rvm.sh`

```shell
[root@web ~]# source /etc/profile.d/rvm.sh
```

5、查看RVM可安装的ruby的版本

```shell
 1 [root@web ~]# rvm list known
 2 # MRI Rubies
 3 [ruby-]1.8.6[-p420]
 4 [ruby-]1.8.7[-head] # security released on head
 5 [ruby-]1.9.1[-p431]
 6 [ruby-]1.9.2[-p330]
 7 [ruby-]1.9.3[-p551]
 8 [ruby-]2.0.0[-p648]
 9 [ruby-]2.1[.10]
10 [ruby-]2.2[.7]
11 [ruby-]2.3[.4]
12 [ruby-]2.4[.1]
13 ruby-head
14 
15 # for forks use: rvm install ruby-head-<name> --url https://github.com/github/ruby.git --branch 2.2
16 
17 # JRuby
18 jruby-1.6[.8]
19 jruby-1.7[.27]
20 jruby[-9.1.13.0]
21 jruby-head
22 
23 # Rubinius
24 rbx-1[.4.3]
25 rbx-2.3[.0]
26 rbx-2.4[.1]
27 rbx-2[.5.8]
28 rbx-3[.84]
29 rbx-head
30 
31 # Opal
32 opal
33 
34 # Minimalistic ruby implementation - ISO 30170:2012
35 mruby-1.0.0
36 mruby-1.1.0
37 mruby-1.2.0
38 mruby-1[.3.0]
39 mruby[-head]
40 
41 # Ruby Enterprise Edition
42 ree-1.8.6
43 ree[-1.8.7][-2012.02]
44 
45 # Topaz
46 topaz
47 
48 # MagLev
49 maglev[-head]
50 maglev-1.0.0
51 
52 # Mac OS X Snow Leopard Or Newer
53 macruby-0.10
54 macruby-0.11
55 macruby[-0.12]
56 macruby-nightly
57 macruby-head
58 
59 # IronRuby
60 ironruby[-1.1.3]
61 ironruby-head
```

6、安装ruby-1.9.3版本

```shell
 1 [root@web ~]# rvm install 1.9.3
 2 Searching for binary rubies, this might take some time.
 3 Found remote file https://rvm_io.global.ssl.fastly.net/binaries/centos/6/x86_64/ruby-1.9.3-p551.tar.bz2
 4 Checking requirements for centos.
 5 Installing requirements for centos.
 6 Installing required packages: libffi-devel, readline-devel, sqlite-devel, zlib-devel, libyaml-devel, openssl-devel...........|
 7 Requirements installation successful.
 8 ruby-1.9.3-p551 - #configure
 9 ruby-1.9.3-p551 - #download
10   % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
11                                  Dload  Upload   Total   Spent    Left  Speed
12 100 10.2M  100 10.2M    0     0   188k      0  0:00:55  0:00:55 --:--:--  223k
13 ruby-1.9.3-p551 - #validate archive
14 ruby-1.9.3-p551 - #extract
15 ruby-1.9.3-p551 - #validate binary
16 ruby-1.9.3-p551 - #setup
17 ruby-1.9.3-p551 - #gemset created /usr/local/rvm/gems/ruby-1.9.3-p551@global
18 ruby-1.9.3-p551 - #importing gemset /usr/local/rvm/gemsets/global.gems...................................
19 ruby-1.9.3-p551 - #generating global wrappers........
20 ruby-1.9.3-p551 - #gemset created /usr/local/rvm/gems/ruby-1.9.3-p551
21 ruby-1.9.3-p551 - #importing gemsetfile /usr/local/rvm/gemsets/default.gems evaluated to empty gem list
22 ruby-1.9.3-p551 - #generating default wrappers........
```

7、查看ruby是否升级成功

```shell
1 [root@web ~]# ruby -v
2 ruby 1.9.3p551 (2014-11-13 revision 48407) [x86_64-linux]
```

至此，ruby版本升级成功



转载自：https://www.cnblogs.com/eeexu123/p/9228044.html





 **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**