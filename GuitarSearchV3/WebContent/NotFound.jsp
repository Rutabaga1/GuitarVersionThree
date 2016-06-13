<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuitarNotFound</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >

</head>

<body>

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
			<h3>喜欢音乐</h3>
			<span>: 一定让您满意     ${requestScope.userName }</span>
			<p align="right"><a href="GuitarAdd.jsp"><strong><font color="green" size="3">添加</font></strong></a>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="GuitarDelete.jsp"><strong><font color="brown" size="3">删除</font></strong></a>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="SignOut"><strong><font size="3">退出</font></strong></a>
			</p>
		</div>
	</div>

	<!-- START CONTENT -->
	<div class="center-block-page clearfix">
	  <form action="GuitarSearch"  >
		<table> 
			<tbody>
			<tr>
		   			<td colspan="3"><hr size="1" /></td>
		   		</tr>
		  <tr> <td colspan="3"> 
			
				<input type="radio" name="search" value="allGuitar"><strong>全部吉他</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			 <hr size="1" />
			<br /> 
			</td></tr>
		    
		   		<tr>
		   			<td rowspan="2"><input type="radio" name="search" value="02" checked="checked"><strong>筛选</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td >颜色：&nbsp;<input type="text" name="color" maxlength="2" value="${requestScope.color }" /></td>
		   			<td>类型：&nbsp;
		   				<select name="type" size="1">
		   					<option value="acoustic">acoustic</option>
		   					<option value="electric">electric</option>
		   					<option value="allType" selected="selected">任意</option>
		   				</select>
		   			<%-- <input type="text" name="type" value="${requestScope.type }" /> --%>&nbsp;</td>
		   			
		   		</tr>
		   		<tr>
		   			<td>弦数：&nbsp;<input type="text" name="numStrings" value="${requestScope.numStrings }" />&nbsp;</td>
		 
		   			<td>品牌：&nbsp;
		   			<select name="builder" size="1">
		   					<option value="Martin">Martin</option>
		   					<option value="Taylor">Taylor</option>
		   					<option value="Gibson">Gibson</option>
		   					<option value="Yamaha">Yamaha</option>
		   					<option value="Cort">Cort</option>
		   					<option value="Takamine">Takamine</option>
		   					<option value="allBuilder" selected="selected">任意</option>
		   				</select>
		   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<!-- <td>库存量：&nbsp;
		   				<input type="checkbox" name="inventory" value="00" checked="checked" />仅显示有库存量的
		   			&nbsp;</td> -->
		   		</tr>
		   		<tr>
		   			<td colspan="3" align="center"><input type="submit" value="确定" /></td>
		   		
				</tr>
		   		<tr>
		   			<td colspan="3"><hr size="1" /></td>
		   		</tr>
		   		
			</tbody>
		   </table>   
		</form>
				<br />
				<p><font color="gray">抱歉，没有找到符合条件的吉他，换筛选条件再试试！</font></p>
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