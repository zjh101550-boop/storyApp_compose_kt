负责app\src\main\java\com\codelab\basiclayouts\ui\screens\shared界面，目前还剩主界面及profile，以及navicat数据库的连接，最后可添加google注册流程

分层逻辑：

1. UI层（使用Jetpack Compose）
   职责：构建和管理用户界面，响应用户输入，展示数据。
   技术：Jetpack Compose，这是一种声明式的UI工具库，允许开发者用更直观的方式构建Android应用的UI。
   代码特点：主要包含@Composable函数，这些函数定义了应用的视图和布局。
2. ViewModel层（Kotlin/Java）
   职责：作为UI层和数据处理层之间的桥梁，管理UI相关的数据状态和业务逻辑。ViewModel持有界面数据，处理数据变化，将业务逻辑的结果反馈给UI层。
   技术：ViewModel组件（一部分Jetpack库），LiveData或Flow，这些组件和库帮助处理数据流和生命周期管理。
   代码特点：不包含任何UI代码，只包含数据和状态管理逻辑。
3. Domain层（Kotlin/Java）
   职责：包含应用的业务逻辑。这一层定义了应用的核心功能，独立于其他层。
   技术：纯Kotlin或Java代码，用于定义业务实体（Entities）、业务规则和用例（Use Cases）。
   代码特点：通常不依赖任何特定的框架，确保业务逻辑的独立性和可重用性。
4. Data层（Kotlin/Java）
   职责：负责数据的持久化和网络通信，实现Domain层定义的接口。
   技术：Room（用于数据库交互）、Retrofit（用于网络请求）、其他可能的数据持久化或网络通信库。
   代码特点：包含数据访问对象（DAO）、数据传输对象（DTOs）、仓库实现（Repositories）等。
