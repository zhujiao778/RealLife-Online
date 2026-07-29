🎮 现实世界OL (RealLife Online) - 人生游戏化管理系统

“停止在虚拟世界里疯狂打怪升级，是时候在现实世界中为自己肝经验了！”

📖 项目简介 (Introduction)

现实世界OL 是一个将个人健康、时间管理和技能成长全面“游戏化 (Gamification)”的全栈开源系统。

我们总是很容易沉迷于游戏中的数值成长，却对现实中自己的进步缺乏感知。本项目旨在通过 RPG 游戏的 UI 风格和逻辑机制，将你的体力(HP)、精力(MP)、现实技能(如：编程、做饭、健身) 以及 日常任务 进行量化。每完成一次番茄钟专注，每划掉一个 Todo，你都会看到经验条的增长、技能的升级，从而获得极大的正向反馈，战胜拖延症！

✨ 核心玩法 (Features)

🧑‍🎤 状态面板 (Status Panel)：

基于 ECharts 渲染的动态六维机能雷达图（力量、敏捷、体质、智力、魅力、幸运）。

红蓝条机制：HP（影响持续行动力）、MP（专注修炼需消耗蓝量）。

📚 技能树 (Skill Tree)：

万物皆可数值化。你可以添加“Java 开发”、“吉他”、“英语口语”等技能。

稀有度系统：从普通(白)到传说(金)，不同品质技能拥有不同的视觉特效和升级难度。

每次专注都会为特定技能注入 EXP，见证技能从 Lv.1 突破到 Lv.99！

⏱️ 专注修炼 (Pomodoro)：

沉浸式的番茄钟打坐系统。

开始专注会消耗 MP，完成后增加总体经验 (EXP) 并同步升级技能，若强行中断则会“走火入魔”。

⚔️ 讨伐任务 (Quest Board)：

轻量级的 Todo-List。自发接取每日任务（如：通关 LeetCode 一道 Hard），完成后领取海量经验奖励。

🏆 领域展开 (Achievements & Data)：

数据可视化中心。自动统计本周专注时长趋势（柱状图）与技能修炼精力分布（饼图）。

支持“修炼卷轴”手动补录记录，防止遗漏任何一次现实中的努力。

🛠️ 技术栈 (Tech Stack)

前端 (Frontend)

核心框架: Vue 3 (Composition API)

UI 组件库: Element Plus (深度定制暗黑游戏主题)

数据可视化: Apache ECharts 5

网络请求: Axios

后端 (Backend)

核心框架: Spring Boot 3

持久层框架: MyBatis / MyBatis-Plus

数据库: MySQL 8.0

接口规范: RESTful API + 统一 Result<T> 封装

🚀 快速开始 (Quick Start)

1. 环境要求

Node.js >= 16.x

JDK >= 17

MySQL >= 8.0

2. 数据库初始化

在 MySQL 中执行项目根目录下的 sql/init.sql 文件，创建 life_game_db 数据库及所需表结构。

3. 后端启动

cd backend
# 修改 application.yml 中的数据库连接信息
# 使用 Maven 编译并启动
mvn spring-boot:run


4. 前端启动

cd frontend
npm install
# 启动开发服务器
npm run dev


访问 http://localhost:5173 即可进入你的现实世界专属面板！

📸 界面预览 (Screenshots)

(提示：建议在这里放几张你的项目截图)

状态面板 & 雷达图：![状态面板](./docs/images/status.png)

番茄钟专注修炼：![番茄钟](./docs/images/pomodoro.png)

技能树与图表统计：![技能与统计](./docs/images/charts.png)

🗺️ 未来版本路线图 (Roadmap)

[ ] 装备系统：完成特殊任务掉落“现实装备”（例如：获得【人体工学椅】增加生命恢复速度）。

[ ] 商城与金币：完成任务获得金币，用于在商城兑换“奖励”（例如：看一场电影、吃一顿大餐）。

[ ] 成就徽章：累计专注 100 小时解锁特殊称号。

[ ] 社交组队：添加好友，组队完成大型现实挑战。

🤝 参与贡献 (Contributing)

欢迎所有热爱生活、热爱代码的“高阶玩家”加入项目的开发！如果你有好的点子或者发现了 Bug，欢迎提交 Issue 或 Pull Request。

Fork 本仓库

创建你的特性分支 (git checkout -b feature/AmazingFeature)

提交你的更改 (git commit -m 'Add some AmazingFeature')

推送到分支 (git push origin feature/AmazingFeature)

开启一个 Pull Request

📄 开源协议 (License)

本项目采用 MIT License 开源协议，你可以自由地使用、修改和分发。

“祝你武运昌隆，在现实世界中早日满级！” ⚔️
