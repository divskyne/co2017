<link rel='stylesheet' href='../web/swiss.css'/>

# CO2006 MINI PROJECT 16-17: eMarket 

In this sprint, the goal is to implement a first release of an online shop with the following functional features:
* Management of a product (from the exercises)
* Creation of orders with products from the catalogue

The scenarios to be implemented are specified using Gherkin notation in [Order.feature](./Order.feature). A demo of how these scenarios should be implemented is available at the beginning of this  :movie_camera: [lecture](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=68cbf3a2-be0f-4080-a29a-49f84d556d98).

## Marking criteria

### Implementation and testing of functional features (78 marks)

In the following table, you will find a classification of features according to their priority in order to guide their development: `@should` scenarios should be implemented before `@could` scenarios (although this is only a recommendation).


| Scenario | Priority | Marks for development | Marks for testing | Total |
|----------|----------|-----------------------|-------------------|-------| 
| Order.Navigation.Get | `@should` | 9 | 9 | 18 | 
| Order.Logic.Create  | `@should` | 3 | 3 | 6 |
| Order.Logic.Delete | `@should` | 3 | 3 | 6 |
| Item.Navigation.Post | `@could` | 3 | 3 | 6 |
| Item.Navigation.Get | `@could` | 6 | 6 | 12 |
| Item.Logic.Create | `@should` | 3 | 3 | 6 |
| Item.Logic.Create.Exception | `@could` | 3 | 3 | 6 |
| Item.Logic.Edit | `@could` | 3 | 3 | 6 |
| Item.Logic.Edit.Exception | `@could` | 3 | 3 | 6 |
| Item.Logic.Delete | `@could` | 3 | 3 | 6 |

**Marking guidelines**: each scenario is marked out of 3 marks twice (first for assessing the implementation using Spring MVC, and the second time to assess the testing aspect, using SpringMvc Test, Cucumber and HamCrest). Each implementation and testing aspect of a scenario is marked as follows:
* 1: code does not compile but there is an thoughtful attempt at implementing the scenarios.
* 2: code does compile but contains errors (e.g. it is not testing what it should test). Code is readable. Some functionality from the frameworks and libraries (SpringMvc, SpringMvc Test, HamCrest) are not used correctly.
* 3: code is fit for purpose and is well documented (and readable). Excellent use of frameworks and libraries (SpringMvc, SpringMvc Test, HamCrest).

### JSP Views (15 marks)

Each view is worth 5 marks
* **orderMaster.jsp**: view with the complete list of orders showing their details as in the demo (including a brief summary of products involved and the total cost) with the following actions: add, edit and delete specific orders.
* **orderDetail.jsp**: view with the details of a given order, listing all of its items, including: product (name, description, price), amount and cost. It should include the following actions: add, edit and delete order items.
* **itemDetail.jsp**: view the details of a specific order item, showing the product involved and the amount required. It should provide the following actions: 
  * choosing a product from the catalogue;
  * adding an item to an order.

**Marking guidelines**: 
* 1-2: views are not working although there is an attempt at implementing them with the expression language and with EL.
* 2-3: readable JSPs, with the presence of some bugs. The expression language EL is used to fetch information from the model mostly correctly and JSTL and Spring tag libraries are used.  
* 4-5: well documented, readable JSPs, work perfectly well using the expression language to fetch information from the model and using JSTL to generate structured HTML. Proper use of JSTL and Spring tag libraries. 


### Submission procedure (7 marks)
* Commit and push your mini project (the whole project) to your GitHub repository, under the folder `root/sprint2/mini-project` so that you can find your file `gradle.build` in `root/sprint2/mini-project/gradle.build` 
* Make a release on GitHub
  1. Open the repo in Github
  2. Click Releases
  3. Click `Create a new release` 
  4. Enter the `Tag Version` as `ws1` (leave `@ Target Master`)
  5. Enter the `Release Title` as `Worksheet 1 submission`
  6. Click `Publish Release` 
* Clone your repository in a new workspace and check that `root/sprint2/mini-project/gradlew check` generates a report in folder `root/sprint2/mini-project/build/cucumber-html-report/index.html`

