//操作工具栏的关闭和打开
function switchSysBar(){
	if (switchPoint.innerText==3){
		switchPoint.innerText=4
		document.all("frmMenu").style.display="none"
	}
	else{
		switchPoint.innerText=3
		document.all("frmMenu").style.display=""
	}
}
//程序功能描述
function expandTopFrame(){
	if (typeof(frmright)!="undefined"){
 		if (typeof(frmright.frmWorkSpace)!="undefined"){
	 		if (typeof(frmright.frmWorkSpace.frmMain)!="undefined"){
				frmright.frmWorkSpace.frmMain.rows="*,0"
			}
		}
	}	
}
//程序功能描述
function expandBottomFrame(){
	if (typeof(frmright)!="undefined"){
 		if (typeof(frmright.frmWorkSpace)!="undefined"){
	 		if (typeof(frmright.frmWorkSpace.frmMain)!="undefined"){
				frmright.frmWorkSpace.frmMain.rows="0,*"
			}
		}
	}
}
//程序功能描述
function restoreSplit(){
	if (typeof(frmright)!="undefined"){
 		if (typeof(frmright.frmWorkSpace)!="undefined"){
	 		if (typeof(frmright.frmWorkSpace.frmMain)!="undefined"){
				frmright.frmWorkSpace.frmMain.rows="*,300"
			}
		}
	}
	
}