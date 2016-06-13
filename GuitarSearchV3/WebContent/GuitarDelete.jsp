<%@ page import="main.java.service.SearchService,main.java.model.Inventory,java.util.List,main.java.model.Guitar,main.java.model.GuitarSpec,java.util.Iterator"
 language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuitarDelete</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >

</head>

<body>


<%
	SearchService userService = new SearchService();
	List<Guitar> Guitars=userService.getAllGuitars();
	
	String username = (String) request.getSession().getAttribute("login");
%>

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
			<h3>删除吉他库存</h3>
			<span>: <%=username %>&nbsp;&nbsp;您好！</span>
			<p align="right"><a href="GuitarAdd.jsp"><strong><font color="green" size="3">添加</font></strong></a>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="GuitarDelete.jsp"><strong><font color="brown" size="3">删除</font></strong></a>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="SignOut"><strong><font size="3">退出</font></strong></a>
			</p>
		</div>
	</div>

	<!-- START CONTENT -->
	<div class="center-block-page clearfix">
	  <form action="GuitarDelete"  >
		   <table>
			<tbody>
				<tr>
		   			<td colspan="8" align="center"><input type="submit" value="删除"></td>
		   		</tr>
				<tr>
					<td align="center">&nbsp;&nbsp;</td>
					<td align="center"><strong>图片</strong></td>
		   			<td align="center"><strong>类型</strong></td>
		   			<td align="center"><strong>价格</strong></td>
		   			<td align="center"><strong>弦数</strong></td>
		   			<td align="center"><strong>颜色</strong></td>
		   			<td align="center"><strong>品牌</strong></td>
		   			<td align="center"><strong>库存量</strong></td>
		   		</tr>
		   		
			<%
			for (Iterator<Guitar> i = Guitars.iterator(); i.hasNext(); ) {
		        Guitar instrument =i.next();
		        GuitarSpec spec = instrument.getSpec();
		   	%>
		   		
		   		<tr>
		   			<td colspan="8"><hr size="1" /></td>
		   		</tr>
		   	
		   		<tr height="140px">
		   			<td><input type="checkbox" name="delete" value="<%=instrument.getSerialNumber() %>"></td>
		   			<td width="195px"><img src="images/<%=instrument.getSerialNumber() %>.jpg" width="130px" height="130px"></td>
		   			<td align="center" width="100px"><%=spec.getType() %></td>
		   			<td align="center" width="100px"><%=instrument.getPrice() %></td>
		   			<td align="center" width="100px"><%=spec.getNumStrings() %></td>
		   			<td align="center" width="100px"><%=spec.getColor() %></td>
		   			<td align="center" width="100px"><%=spec.getBuilder() %></td>
		   			<td align="center" width="100px"><%=instrument.getInventoryNum() %></td>
		   		</tr>	
		   		
		   		<%} %>
			</tbody>
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