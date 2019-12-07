$(document).ready(function(){
	  tid=setInterval('msg_time()',1000); // 타이머 1초간격으로 수행
	});

	var stDate = new Date().getTime();
	var edDate = new Date(getEnd_time()).getTime(); // 종료날짜
	var RemainDate = edDate - stDate;
	 
	function msg_time() {
	  var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
	  var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
	  var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
	  
	  m = hours + ":" +  miniutes + ":" + seconds ; // 남은 시간 text형태로 변경
	  
	  document.all.timer.innerHTML = m;   // div 영역에 보여줌 
	  
	  if (RemainDate < 0) {      
	    // 시간이 종료 되었으면..
	    clearInterval(tid);   // 타이머 해제
	  }else{
	    RemainDate = RemainDate - 1000; // 남은시간 -1초
	  }
	}