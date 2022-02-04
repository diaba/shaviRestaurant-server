
<h1 align="center">Capstone Project</h1>

![mobile image](https://github.com/diaba/shaviRestaurant-server/blob/main/image/mobile.png?raw=true "Mobile")

#Description
Shavi’s Restaurant is an app that allows Shavi’s Restaurant customers to view the restaurant menu. They also can order a meal and choose the deliver method that can be carryout or delivery.
## Goals
My goal is to build a fully responsive web application that is secured and that meets my client requirement.
## Approch
- Provide a user experience study
- Create a full prototype
- Get feedback from users
- Create my backend application
- Connect my backend and my frontend
- Every night work on deployment, document and do some research for next step as needed. 
#User stories
-	As a user I need to register so that I can login.
-	As a customer, I need to login so that I can save my payment information for my next order.
-	As a customer, I need to be able to change my delivery option so I can use carryout or delivery method.
-	As a customer I need to see all menu so that I can choose a meal to order.
-	As a customer I need to login so that I can see my previous order.
-	As a customer I need to login in so that I can update my information.
-	As a customer I need to able to choose many meals so that I don’t need to make many orders.
-	As a customer I need to receive my order confirmation details so that I can track my order.
-	As a customer I need a responsive website to that I can order using my phone.
#ERD


![ERD image](https://github.com/diaba/shaviRestaurant-server/blob/main/image/erd.jpeg?raw=true "Final ERD")

#Wireframes

![home Image](https://github.com/diaba/shaviRestaurant-client/blob/main/image/wireframes/Home%20-%20item%201%20%E2%80%93%201.png?raw=true "Project wireframe")
##Checkout
![checkout Image]( https://github.com/diaba/shaviRestaurant-client/blob/main/image/wireframes/Home%20-%20Checkout.png?raw=true "Project Start ERD")
##Menu
![menu Image](https://github.com/diaba/shaviRestaurant-client/blob/main/image/wireframes/Home%20-%20items%201.png?raw=true "Project wareframe")
##Project Plan

![plan image](https://github.com/diaba/shaviRestaurant-server/blob/main/image/timeLine.png?raw=true "Plan")

### Technology Used
##### Planning
![ERD image](https://github.com/diaba/shaviRestaurant-server/blob/main/image/timeLine.png?raw=true "timeLine")
##### Back-end
- Java SpringBoot
- Maven
- PostGreSQL
##### Front-end
- Angular
- Boostrap
##### Deployment
- AWS

### Dependencies
##### Back-end (Maven)
- spring-boot-starter-data-jpa
- jwt
- spring-security-web
- spring-security-config
- spring-security-core
- postgresql
##### Front-End (Angular)
- BrowserModule
- AppRoutingModule
- BrowserAnimationsModule
- FormsModule
- HttpClientModule
- NgbModule
- HTTP_INTERCEPTORS


This project involved using a REST API for a restaurant that allows it customers to make online order. The restaurant admin will have access to update 
food and to handle delivery tracking.
The database has endpoints for users and admins, which require proper authentication using a JSON Web Token.

In the application the customer is given a responsive platform.


## Entity Relationship Diagram (ERD):
![ERD Image](https://github.com/diaba/shaviRestaurant-server/blob/main/image/ShaviDb.drawio.png?raw=true "Project ERD")![img.png](images/imgErd1.png)

## POM Dependencies

![ERD Image](https://github.com/diaba/shaviRestaurant-server/blob/main/image/dependencies.png?raw=true "Project ERD")


## Endpoints

| Endpoints                                                                        | Methods | Access  |  
|----------------------------------------------------------------------------------|---------|---------|
| auth/users/register                                                              | POST    | Public  |
| auth/users/login                                                                 | POST    | Public  |
| api/customers                                                                    | PUT     | Public  |
| api/customers                                                                    | GET     | Public  |
| api/categories                                                                   | GET     | Public  |
| api/categories/{categoryId}                                                      | GET     | Public  |
| api/categories/{categoryId}/meals/{mealId}                                       | GET     | Public  |
| api/categories/{categoryId}/meals                                                | GET     | Public  |
| api/meals                                                                        | GET     | Public  |
| api/orders                                                                       | POST    | Private |
| api/orders/{orderId}                                                             | GET     | Private |
| api/orders                                                                       | GET     | Private |
| api/orders                                                                       | PUT     | Private |
| api/orders                                                                       | GET     | Private |
| api/payments                                                                     | GET     | Private |
| api/payments/{paymentId}                                                         | GET     | Private |
| api/payments/{paymentId}                                                         | DELETE  | Private |
| api/payments/{paymentId}                                                         | POST    | Private |
| api/payments/{paymentId}                                                         | PUT     | Private |
| api/delivery/tracking                                                            | GET     | Public  |
| api/customers/{customerId}/customerOrder/{customerOrderId}/delivery/{deliveryId} | PUT     | Private |
| api/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId} | GET     | Public  |
| api/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId} | PUT     | Private |



## System Tools Used

|                                                                                                                      |  |
|----------------------------------------------------------------------------------------------------------------------| :--- |
| ![img_5.png](https://git.generalassemb.ly/matthewljames/paypal-java-capstone-project/blob/master/images/img_5.png)   | Spring Boot
| ![img_7.png](https://git.generalassemb.ly/matthewljames/paypal-java-capstone-project/blob/master/images/img_7.png)   | Postman
| ![img_8.png](https://git.generalassemb.ly/matthewljames/paypal-java-capstone-project/blob/master/images/img_8.png)   | Json Web Tokens
| ![img_6.png](https://git.generalassemb.ly/matthewljames/paypal-java-capstone-project/blob/master/images/img_6.png)   | IntelliJ IDEA 17
| ![img_9.png](https://git.generalassemb.ly/matthewljames/paypal-java-capstone-project/blob/master/images/img_9.png)   | Postgres
| ![img_14.png](https://git.generalassemb.ly/matthewljames/paypal-java-capstone-project/blob/master/images/img_14.png) | GitHub 

## User Stories

![img_16.png](https://www.google.com/url?sa=i&url=https%3A%2F%2Fblog.scrumstudy.com%2Fvarious-methods-for-user-story-prioritization%2F&psig=AOvVaw3raSYn70-Ns70bwEI8MspG&ust=1644026348151000&source=images&cd=vfe&ved=0CAgQjRxqFwoTCKCF6s755PUCFQAAAAAdAAAAABAE)

| | 
|:---|


## Project Challenges

![img_4.png](https://miro.medium.com/max/9552/1*z1Pzkz6_bF3hTc7r9V7lsA.png)

1. The first coding challenge that took me a significant time to solve was with deploying my backend to AWS. After multiple 
tries to fix it I request an issue ticket. I found out that I needed to do more configuration on AWS side.
2. I run to login credentials issues using JWT. I discovered that I did not configure correctly my dependencies.

3. When implementing my backend my biggest challenge was to transfer temporary data without sending it to the server. After
talking with my project lead I used localstorage functionalities.

#Repos
- 👨‍💻 Backend
  - Git url [here](git@github.com:diaba/shaviRestaurant-server.git)
  - api website [here](http://diaba-env.eba-vem8qkrq.us-east-1.elasticbeanstalk.com/api/meals)
- 👨‍💻 Frontend
  - [here](git@github.com:diaba/shaviRestaurant-client.git)
  - Git url [here](https://angularbacket.s3.us-east-2.amazonaws.com/)

#Resources used
- https://www.youtube.com/watch?v=6SadWaJrtnY
- https://www.baeldung.com/spring-boot-angular-web
- https://devcenter.heroku.com/
- https://angular.io
- https://www.remotestack.io/create-login-ui-template-with-angular-material-design/
- https://jasonwatmore.com/post/2018/10/29/angular-7-user-registration-and-login-example-tutorial