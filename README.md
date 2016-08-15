# Quartz 企业作业队调度框架
###什么事Quartz 企业作业队调度框架？
Quartz是一款可以集成在从小型的独立运行的应用程序到大型的商务系统的几乎所有的java应用程序的一款功能丰富、开放源代码的作业调度类库。Quartz可以为执行十个、百个、甚至是成千上外的作业创建简单或复杂的的调度。他们的任务是定义为一个标准的java组件，可以执行几乎任何你可以计划去做的工作。Quartz调度包括很多企业级功能，如JTA事务支持和聚类。<br>

Quartz是可以自由使用的，许可在Apache 2许可证。<br>

###Quartz可以为你做些什么呢？
如果你的应用程序需要在给定的时间内执行某些任务，或者你的系统经常性的需要维护工作，那么Quartz可能是你的理想决解方案。<br>

使用Quartz作业调度样例<br>

* 驱动流程：在最初的位置调度一个在确切的2小时后执行的作业作为一个新的订单，检查这个订单的状态，如果订单确认消息尚未收到以及订单改变了那么回触发一个警告并通知。

* 系统维护：每日下午11:30调度一个从数据从数据库转到xml文件中的作业。(所有工作日假期除外

* 在应用中提供消息提醒服务

有关更多信息,请参考我们的[功能清单](http://www.quartz-scheduler.org/overview/features)。

##Quartz的特性
###运行时环境
* Quartz可以嵌入到另一个独立的应用程序运行

* Quartz可以在实例化一个应用服务器(或servlet容器),并参与XA事务

* Quartz可以通过RMI运行作为一个独立的程序(在自己的Java虚拟机)

* Quartz可以作为独立的集群实例化程序(负载平衡和故障转移功能)的执行作业

###作业调度
当给定一个触发时作业将被调度执行，触发器可以创建几乎任何组合的下列指令:

* 在一定的时间(毫秒)

* 在每周特定的日子 

* 在每月特定的日子

* 在每年特定的日子

* 不是在几天内注册日历(例如业务假期)

* 重复一个特定的次数

* 重复,直到一个特定的时间/日期

* 无限重复

* 延迟间隔反复

作业被创建它们的人赋予名字也可以把它们组织成命名组。为了方便组织调度器，触发器可能也有名字并放置成一组。作业可以一次性被添加到触发器，并注册多个触发器。企业内的java环境，作业可以执行它们的工作作为一个分布式(XA)事务的一部分。

###作业执行
* 作业可以是任何实现了简单的作业接口的java类，并且留下的无限可能性的工作让你的作业可以执行

* 作业类可以被Quzrtz实例化，或者可以通过应用程序框架

* 当触发器发生时，调度器通知零个或者多个实现了JobListener和TriggerListener接口（监听器可以是简单的Java对象,或ejb,或JMS出版商,等等）的java对象，在作业执行之后这些监听器也会被通知到 

* 当一个作业完成之后，它会返回一个JobCompletionCode来通知调度器该作业是成功了还是失败了。JobCompletionCode还可以根据成活或者失败的代码来指示调度器应该采取什么样的行动，如立即re-execution的工作

###作业持久化

* Quartz的设计包括一个JobStore接口，它可以提供各种机制实现存储的作业

* 使用包括JDBCJobStore,所有作业和配置为“非易失性”的触发器是通过JDBC存储在关系数据库中

* 使用包括RAMJobStore,所有作业和存储在RAM中的触发器,因此不存在之间的程序执行,这些有事已经不需要一个外部数据库了。

###事务

* Quartz可以参与JTA事务,通过使用JobStoreCMT(JDBCJobStore的子类)。

* Quartz可以管理JTA事务(开始、提交)的执行作业,因此作业执行的工作自动发生在一个JTA事务中

###聚类

* 故障转移

* 负载均衡

* Quartz的内置集群特性依赖数据库持久性通过JDBCJobStore(如上所述)

* Terracotta扩展Quartz提供集群功能不需要数据库的支持。

###监听和插件
* 应用程序可以通过监听或者作业控制/触发行为通过实现一个或多个侦听器接口来捕获事件

##Quartz教程：快速入门
 
欢迎来到quartz快速入门教程。阅读本教程，你将会了解：

quartz下载

quartz安装

根据你的需要，配置Quartz开始一个示例应用

当熟悉了quratz调度的基本功能后，可以尝试一些更高级的特性，比如Where，这个一个企业级功能，可以让job和trigger运行在指定的，而不是随机的Terracotta客户端上。

###下载和安装

首先，[下载最新的稳定版](http://www.quartz-scheduler.org/downloads/) – 不用注册。解压并安装。

**Quartz jar文件**

quartz安装包根目录的lib/目录下有很多的jar包。其中，quartz-xxx.jar（其中xxx是版本号）是最主要的。为了使用quartz，必须将该jar包放在应用的classpath下；

下载后，解压，然后将quartz-xxx.jar放到你的应用中。

我主要是在应用服务器的环境中使用quartz，所以一般将quartz jar包放到应用中（.ear或.war）。当然，如果你希望在很多应用中使用quartz，将quartz的jar包放在应用服务器(appserver)的classpath下即可。如果你只是希望在独立的应用中使用quartz，将quartz的jar包和你的应用依赖的其它jar包放在一起即可。

quzrtz依赖一些第三方的库（以jar包的形式），这些库位于quartz安装包的lib目录下。要使用quartz的所有功能，必须将所有的第三方jar包都放到classpath下。如果你开发的是一个独立的quartz应用，建议将所有的jar包都放到classpath下；如果是在应用服务器环境下使用quartz，其中有些包可能已经存在于classpath中了，因此你需要自己选择。

#
	在应用服务器环境下，如果同一个jar文件，存在两个不同的版本，要注意，可能会产生一些奇
	怪的结果；比如，WebLogic包含了一个J2EE的实现（在weblogic.jar中），该实现与
	servlet.jar的实现可能不一致。此时，应该从你的应用中排除掉servlet.jar，这样你就知
	道使用的是哪个类了。
#

**properties文件**

quartz使用名为quartz.properties的配置文件。刚开始时该配置文件不是必须的，但是为了使用最基本的配置，该文件必须位于classpath下。

基于我的个人情况举个例子，我的应用是基于Apache Tomcat开发的。我将所有的配置文件（包括quartz.properties）放到应用根目录下的一个项目中。当我将项目打包成.war文件时，放置配置文件的项目会以jar包的形式进入最终的.war包，所以quartz.properties文件就自动位于classpath中了。

如果你准备构建一个使用quartz的web应用（以.war包的形式），你应该将quartz.properties文件放到WEB-INF/classes目录下。

**配置**

这里包含很多内容。quartz是一个配置很灵活的应用。配置quartz最好的方式是，编辑quartz.properties文件，然后放到应用的classpath下。

quartz的安装包中包含了一些配置文件的示例，位于example/目录下。我建议你创建自己的quartz.properties文件，而不是简单地从示例中拷贝并删除不需要的部分。这样看起来更整洁，而且你也会了解到quartz的更多功能。

关于quartz配置文件的详细文档，请查阅[Quartz配置参考](http://www.quartz-scheduler.org/documentation/quartz-2.2.x/configuration/)

为了使用quartz，一个基本的quartz.properties配置文件如下所示：

	org.quartz.scheduler.instanceName = MyScheduler
	org.quartz.threadPool.threadCount = 3
	org.quartz.jobStore.class = org.quartz.simpl.RAMJobStore

上述配置的scheduler有如下特点：

* org.quartz.scheduler.instanceName scheduler的名称为“MyScheduler”

* org.quartz.threadPool.threadCount 线程池中有3个线程，即最多可以同时执行3个job；

* org.quartz.jobStore.class quartz的所有数据，包括job和trigger的配置，都会存储在内存中（而不是数据库里）。如果你想使用quartz的数据库存储功能（校对注：设置成另外一个类），我们建议在使用数据库存储之前，先使用内存存储（RamJobStore）。

###示例应用

下载和安装完quartz后，是时候开发一个示例应用，并让它跑起来了。下面的示例代码，获取scheduler实例对象，启动，然后关闭。

QuartzTest.java

#
    import org.quartz.Scheduler;
    import org.quartz.SchedulerException;
    import org.quartz.impl.StdSchedulerFactory;
    import static org.quartz.JobBuilder.*;
    import static org.quartz.TriggerBuilder.*;
    import static org.quartz.SimpleScheduleBuilder.*;

    public class QuartzTest {

        public static void main(String[] args) {

            try {
                // Grab the Scheduler instance from the Factory 
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

                // and start it off
                scheduler.start();

                scheduler.shutdown();

            } catch (SchedulerException se) {
                se.printStackTrace();
            }
        }
    }
#

	当你调用StdSchedulerFactory.getDefaultScheduler()获取scheduler实例对象后，在
	调用scheduler.shutdown()之前，scheduler不会终止，因为还有活跃的线程在执行。


注意示例代码中的静态导入(static import)，下面的代码中也会用到它们。

如果你没有配置日志输出，所有的日志会输出到控制台，比如：

	[INFO] 21 Jan 08:46:27.857 AM main [org.quartz.core.QuartzScheduler]
	Quartz Scheduler v.2.0.0-SNAPSHOT created.
	
	[INFO] 21 Jan 08:46:27.859 AM main [org.quartz.simpl.RAMJobStore]
	RAMJobStore initialized.
	
	[INFO] 21 Jan 08:46:27.865 AM main [org.quartz.core.QuartzScheduler]
	Scheduler meta-data: Quartz Scheduler (v2.0.0) 'Scheduler' with instanceId 'NON_CLUSTERED'
	  Scheduler class: 'org.quartz.core.QuartzScheduler' - running locally.
	  NOT STARTED.
	  Currently in standby mode.
	  Number of jobs executed: 0
	  Using thread pool 'org.quartz.simpl.SimpleThreadPool' - with 50 threads.
	  Using job-store 'org.quartz.simpl.RAMJobStore' - which does not support persistence. and is not clustered.
	
	
	[INFO] 21 Jan 08:46:27.865 AM main [org.quartz.impl.StdSchedulerFactory]
	Quartz scheduler 'Scheduler' initialized from default resource file in Quartz package: 'quartz.properties'
	
	[INFO] 21 Jan 08:46:27.866 AM main [org.quartz.impl.StdSchedulerFactory]
	Quartz scheduler version: 2.0.0
	
	[INFO] 21 Jan 08:46:27.866 AM main [org.quartz.core.QuartzScheduler]
	Scheduler Scheduler_$_NON_CLUSTERED started.
	
	[INFO] 21 Jan 08:46:27.866 AM main [org.quartz.core.QuartzScheduler]
	Scheduler Scheduler_$_NON_CLUSTERED shutting down.
	
	[INFO] 21 Jan 08:46:27.866 AM main [org.quartz.core.QuartzScheduler]
	Scheduler Scheduler_$_NON_CLUSTERED paused.
	
	[INFO] 21 Jan 08:46:27.867 AM main [org.quartz.core.QuartzScheduler]
	Scheduler Scheduler_$_NON_CLUSTERED shutdown complete.

你可以在start()和shutdown()之间做一些有趣的事情：

#
	// define the job and tie it to our HelloJob class
    JobDetail job = newJob(HelloJob.class)
        .withIdentity("job1", "group1")
        .build();

    // Trigger the job to run now, and then repeat every 40 seconds
    Trigger trigger = newTrigger()
        .withIdentity("trigger1", "group1")
        .startNow()
        .withSchedule(simpleSchedule()
                .withIntervalInSeconds(40)
                .repeatForever())            
        .build();

    // Tell quartz to schedule the job using our trigger
    scheduler.scheduleJob(job, trigger);

#	

	在调用shutdown()之前，你需要给job的触发和执行预留一些时间，比如，你可以调用
	Thread.sleep(60000)让线程睡眠一段时间。

好了，自己去探索吧！

#Quartz教程
##第一节，使用Quartz
在你使用程序调度之前，你先需要初始化。要做到这一点，你需要使用到SchedulerFactory。一些Quartz的用户可能在JNDI存储的工厂保存一个实例，其他人可能发现直接使用一个工厂实例化石非常方便的。

一旦调度器被实例化它就启动了，并放置在单独的模块中，然后关闭。注意，一旦调度器关闭，它不能在没有重新实例化的情况下重新启动。触发器不会执行（作业不执行）知道调度器开始启动，它会一直处于暂停的状态。

以下是快速代码片段,实例化并启动调度器以及调度一个作业执行：

#
	SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
	Scheduler sched = schedFact.getScheduler();
	sched.start();
	// define the job and tie it to our HelloJob class
	JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1")
      .build();

	// Trigger the job to run now, and then every 40 seconds
	Trigger trigger = newTrigger().withIdentity("myTrigger", "group1").startNow()
      .withSchedule(simpleSchedule()
          .withIntervalInSeconds(40).repeatForever()).build();
	// Tell quartz to schedule the job using our trigger
	sched.scheduleJob(job, trigger);
#

正如上面的你可以看到，使用Quartz是相当简单的，在第二节中，我们将给出作业、触发器以及Quartz相关的API的介绍让你更加理解这个实例

##第二节，Quartz API,作业和触发器
###Quartz API
Quartz关键的接口如下：

* Scheduler ：调度最主要的接口API

* Job ：你想通过调度器执行的组件需要实现的一个接口

* JobDetail ： 用来定义一个作业的实例

* Trigger ：一个定义了调度器将执行给定的作业列表的组件

* JobBuilder ：用来定义/构建JobDetail的实例并且定义了jobs的实例

* TriggerBuilder ：定义/构建触发器的实例

调度器的生命周期是根据它创建为边界的，通过SchedulerFactory和调用它的shutdown()方法。一旦创建了调度器的接口，那么它可以添加、移除和列出它所有的作业、触发器以及运行其他调度相关的操作（例如暂停一个触发器）。然而，调度不会在任何的触发器上确切的执行直到它调用了start()方法。

Quartz提供了  "builder"类来定义了一种特定领域的语言（DSL），在之前的小节中你看到了如下的例子，以下是其中的一部分：
	
	// define the job and tie it to our HelloJob class
	JobDetail job = newJob(HelloJob.class)
      .withIdentity("myJob", "group1") // name "myJob", group "group1"
      .build();

	// Trigger the job to run now, and then every 40 seconds
	Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
      .startNow().withSchedule(simpleSchedule()
          .withIntervalInSeconds(40).repeatForever()).build();

	// Tell quartz to schedule the job using our trigger
	sched.scheduleJob(job, trigger);

