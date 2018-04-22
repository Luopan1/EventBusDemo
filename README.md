# EventBusDemo1、简介
	EventBus是一个Android端优化的publish/subscribe消息总线，简化了应用程序内各组件间、组件与后台线程间的通信。比如请求网络，等网络返回时通过Handler或Broadcast通知UI，两个Fragment之间需要通过Listener通信，这些需求都可以通过EventBus实现。
		eventbus原理框图.png
2、下载地址
	https://github.com/greenrobot/EventBus
3）使用步骤，（相当于StartActivityOnResult方法  销毁跳转的界面  在onActivityResult中返回的数据）
	1）添加jar包到libs文件夹下
	2）注册
		EventBus.getDefault().register(this);
	3）解注册
		EventBus.getDefault().unregister(this);
	4）构造发送消息类
	5）发布消息
		EventBus.getDefault().post(new MessageEvent("dahaige","123456"));
	6）接收消息
		ThreadMode.MAIN 表示这个方法在主线程中执行
		ThreadMode.BACKGROUND 表示该方法在后台执行，不能并发处理
		ThreadMode.ASYNC 也表示在后台执行，可以异步并发处理。
		ThreadMode.POSTING 表示该方法和消息发送方在同一个线程中执行
4）粘性事件(当前的activity跳转到另外的界面 给别的界面传输消息 )
	之前说的使用方法, 都是需要先注册(register), 再post,才能接受到事件; 

如果你使用postSticky发送事件, 那么可以不需要先注册, 也能接受到事件.
	1）构造发送信息类
	2）发布消息
		EventBus.getDefault().postSticky(new StickyEvent("我是粘性事件"));
	3）接收消息
	4）注册
		EventBus.getDefault().register(CActivity.this);
	5）解注册
5)例子
	1）主线程发送消息
	2）发送粘性事件
