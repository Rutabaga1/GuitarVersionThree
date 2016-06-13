<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuitarAdd</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >

</head>

<body>
<%  String username = (String) request.getSession().getAttribute("login"); %>
 <div id="top-line"></div>

<!-- START LOGO SECTION -->
<div id="logo-bar">
	<div class="center-block clearfix">
		 <div class="logo">
		 <br />
		 <br />
		 <br />
		 
		 	<P align="center"><strong><font color="brown" size="7">吉他</font></strong></P>
		 </div> 
		<div class="ads"><a href="index.jsp"><img src="images/background.jpg" width="290px" height="100px" title="Advertisement" alt="a" /></a></div>
	</div><!-- .center-block -->
</div><!-- #logo-bar -->
<!-- END LOGO SECTION -->

<!-- START WRAPPER SECTION -->
<div id="wrapper">

	<div id="separator">
		<div class="center-block">
			<h3>添加吉他</h3>
			<span>：<%=username %>&nbsp;&nbsp;您好！</span>
			<p align="right"><a href="GuitarAdd.jsp"><strong><font color="green" size="3">添加</font></strong></a>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="GuitarDelete.jsp"><strong><font color="brown" size="3">删除</font></strong></a>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="SignOut"><strong><font size="3">退出</font></strong></a>
			</p>
		</div>
	</div>

	<!-- START CONTENT -->
	<div class="center-block-page clearfix">
	  <form action="GuitarAdd" enctype="multipart/form-data" method="post">
	  	<table width="100%">
	  		<!-- <tr><td align="center"> 序列号：<input type="text" name="serialNumber"></td></tr> -->
	  		<tr><td align="center" colspan="2"> 图片（名称与序列号一致，JPG格式）：<input type="file" name="picture"></td></tr>
	  		<tr><td align="center" colspan="2"> 颜色：<input type="text" name="color"></td></tr>
	  		<tr><td align="center" colspan="2"> 弦数：<input type="text" name="numStrings"></td></tr>
	  		<tr><td align="center" colspan="2"> 价格：<input type="text" name="price"></td></tr>
	  		<tr><td align="center" colspan="2"> 库存量：<input type="text" name="inventoryNum"></td></tr>
	  		<tr >
	  			<td align="right">类型：&nbsp;
		   				<select name="type" size="1">
		   					<option value="acoustic">acoustic</option>
		   					<option value="electric">electric</option>
		   				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   		</td>
		   		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   						品牌：&nbsp;
		   				<select name="builder" size="1">
		   					<option value="Martin">Martin</option>
		   					<option value="Taylor">Taylor</option>
		   					<option value="Gibson">Gibson</option>
		   					<option value="Yamaha">Yamaha</option>
		   					<option value="Cort">Cort</option>
		   					<option value="Takamine">Takamine</option>
		   				</select>
		   		</td>
		   	</tr>
		   	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
	  		<tr><td align="center" colspan="2"><input type="submit" value="添加" ></td></tr>
	  	</table>
		 
		</form>
	</div>
	
</div><!--   width="120px"  #wrapper -->

<!-- END WRAPPER -->	    

<!-- START FOOTER -->
<div class="divider-100-2px"></div>

<!-- START FOOTER MENU  -->
<div id="footer-menu">
	<div class="center-block clearfix">
		<div class="copyright">&copy; Copyright &copy; Electronic Commerce 2013-2.</div>
	</div><!-- .center-block -->
</div><!-- #footer-menu -->
<!-- END FOOTER MENU  -->

</body>
</html>