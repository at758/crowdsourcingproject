<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script src="https://checkout.stripe.com/checkout.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Start changing from here -->
<form action = "CSourcingSH" method = "POST" id="payment-form">
<!--<button id="customButton">Purchase</button>-->

Enter Name<input type="text" value="Enter your name" name="nm"><br>
Net ID<input type="text" value="Enter your netid" name="nid"><br>
I pledge <select id="op1" name="op1">
  <option>0.40</option>
  <option>0.30</option>
  </select>$ for <select id="op2" name= "op2">
  <option>He</option>
  <option>Bu</option>
  <option>Pu</option>
  <option>Ju</option>
  <option>Lu</option>
</select>
<div id="dtag"></div>
<br>
<input type="button" id="customButton" value="Pay">

<input type = "hidden" id = "tokid" name = "stripetok">
<!-- End changing here to you JANANI-->

<script>
  var handler = StripeCheckout.configure({
    key: 'pk_test_RtJ50JhrOhWdMRndNWIunprZ',
    image: '',
    locale: 'auto',
    token: function(token) {
    	document.getElementById('dtag').innerHTML='<b>Please wait while we confirm your payment . . .</b>';
    	
      //return token.id;
      // Use the token to create the charge with a server-side script.
      // You can access the token ID with `token.id`
       $("#tokid").val(token.id);
       $("#payment-form").serialize();
       $("#payment-form").delay(3000).submit();
       

       
     
    	

      
    }
  });

  $('#customButton').on('click', function(e) {
    // Open Checkout with further options
    console.log("aas");
    //document.write($("#op1 option:selected").text() * 10);
    handler.open({
      name: 'CIS Social hour',
      description: 'We dont collect any of your credit card information...',
      amount: $("#op1 option:selected").text() * 100
    });
    e.preventDefault();


  });

  // Close Checkout on page navigation
  $(window).on('popstate', function() {
    console.log("yes");
   
    handler.close();

  });


</script>

</form>




</html>