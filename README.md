# Hospital-Children-RESTFulAPI
Complete REST API project on hospital children records project.

PROJECT DESCRIPTION:

Implement a Restful API that receives a POST, PUT requests and can deliver specified summary
information via GET requests.
The API should be used to register children you are just born within a hospital and should
capture these details:
Name of the child, Place of birth, Registration Number, Date of Birth, gender, Weight, Mother’s
Name, Age of the mother, Occupation, Marital status (married, Single etc.).
Methods:
Description HTTP
Method

URL Payload Response
Create a child POST /addchild {“child”} Child object
Update child
details

PUT /editchild {“child”} Child object

Fetch child
details

GET /search/?name=’’ N/A {data:}

Fetch all children GET /allchildren N/A Page: Current page
Per_page: The maximum
Results per page
Total:total number of results
Total pages: total number of
pages
Data: an array of Json
containing children
information

Ensure you have a data store in place to store these records, they could be in-memory, an
actual database or even a very simple JSON based database.

Exception Messages
No one likes errors, but they happen sometimes. It is necessary to raise an exception in such
cases. When you do this, you should include a meaningful error message to indicate what the
source of the error is. This makes your code more readable and helps significantly with
debugging

Fetch all Children sample
{
"data": [
{
sample data here
}
],
"total": 13,
"total_pages": 2,
"page":2,
"per_page":10
}
