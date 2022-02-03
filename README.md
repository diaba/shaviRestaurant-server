
<h1 align="center">Capstone Project idea</h1>



#Repos
- 👨‍💻 Backend 
  - Git url [here](git@github.com:diaba/shaviRestaurant-server.git)
  - api website [here](http://diaba-env.eba-vem8qkrq.us-east-1.elasticbeanstalk.com/api/meals)
- 👨‍💻 Frontend 
  - [here](git@github.com:diaba/shaviRestaurant-client.git)
  - Git url [here](https://angularbacket.s3.us-east-2.amazonaws.com/)
  


#Description
Shavi’s Restaurant is an app that allows Shavi’s Restaurant customers to view the restaurant menu. They also can order a meal and choose the deliver method that can be carryout or delivery.
## Goals
My goal is to build a working fullstack application that meets my client requirement.
## Approch
- provide a user experience study
- create a full prototype
- get feedback from users
- Create my backend application
- connect my backend and my frontend
- every night work on deployment and do some research for next step as needed. 
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

![ERD Image](https://github.com/diaba/shaviRestaurant-server/blob/main/ShaviDb.drawio.png?raw=true "Project ERD")
![ERD image](https://github.com/diaba/shaviRestaurant-server/blob/main/erd.jpeg?raw=true "Final ERD")

REST API ENDPOINTS

| Endpoints                                                                        | Methods |
|----------------------------------------------------------------------------------|---------|
| auth/users/register                                                              | POST    |
| auth/users/login                                                                 | POST    |
| api/customers                                                                    | PUT     |
| api/customers                                                                    | GET     |
| api/categories                                                                   | GET     |
| api/categories/{categoryId}                                                      | GET     |
| api/categories/{categoryId}/meals/{mealId}                                       | GET     |
| api/categories/{categoryId}/meals                                                | GET     |
| api/meals                                                                        | GET     |
| api/orders                                                                       | POST    |
| api/orders/{orderId}                                                             | GET     |
| api/orders                                                                       | GET     |
| api/orders                                                                       | PUT     |
| api/orders                                                                       | GET     |
| api/payments                                                                     | GET     |
| api/payments/{paymentId}                                                         | GET     |
| api/payments/{paymentId}                                                         | DELETE  |
| api/payments/{paymentId}                                                         | POST    |
| api/payments/{paymentId}                                                         | PUT     |
| api/delivery/tracking                                                            | GET     |
| api/customers/{customerId}/customerOrder/{customerOrderId}/delivery/{deliveryId} | PUT     |
| api/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId} | GET     |
| api/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId} | PUT     |


Project Plan

errors and resolutions logs
- Working in controller handling Many to many relationship beetwen table
  - Break it down work with parent's table and update the linked table
- Add server database from AWS
  - Follow validation steps from AWS documentations
- Dwploy AWS
  - set SERVER_PORT to 6000

achieved goals

Resources used
https://www.youtube.com/watch?v=6SadWaJrtnY
https://www.baeldung.com/spring-boot-angular-web
https://devcenter.heroku.com/
https://angular.io
https:Aws
https://www.remotestack.io/create-login-ui-template-with-angular-material-design/
https://jasonwatmore.com/post/2018/10/29/angular-7-user-registration-and-login-example-tutorial