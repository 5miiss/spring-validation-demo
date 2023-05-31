Spring Validation demo
custom annotation for validating incoming requests to API
use te following link to try it out http://localhost:8080/swagger-ui/index.html#/

if user exists in database it will throw an MethodArgumentNotValidException 
which will be handeled by Exception handler class that will generate the response error