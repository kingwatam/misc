#include <Constants.au3>

$const = 85

$linkx = 220
$linky = 40
$linky = $const - $linky

$agreex = 911
$agreey = 573 - $const

$loginx = 958
$loginy = 672 - $const

$continuex = $loginx
$continuey = 620 - $const

$instance = "Chrome_RenderWidgetHostHWND1"

$instance2 = "Chrome_RenderWidgetHostHWND2"

Opt("WinTitleMatchMode", 2)
While true
	#comments-start
	If WinExists("Not Responding") then
	WinKill("Not Responding", "")
	Sleep(3000)
	EndIf

	If Not(WinExists("[CLASS:Chrome_WidgetWin_1]")) then
		; Run("C:\Program Files (x86)\Google\Chrome\Application\chrome.exe")
		Sleep(500)
		WinSetState("[ACTIVE]", "", @SW_MAXIMIZE)
		Sleep(500)
		MouseClick("Left", 206, 454, 1)
		Sleep (30000)
	EndIf
	#comments-end
	
	If @HOUR >= 2 AND @HOUR <= 4 Then
	
	WinActivate("[CLASS:Chrome_WidgetWin_1]")

	ControlClick("Google Chrome", "", $instance , "Left", 1, $linkx, $linky)
	Sleep (5000)
	ControlSend(WinWait ( "Google Chrome" ), "", $instance , "{F5}")
	Sleep (5000)	
	ControlClick("Google Chrome", "", $instance , "Left", 1, $agreex , $agreey)
	Sleep (5000)
	ControlClick("Google Chrome", "", $instance , "Left", 1, $loginx , $loginy)
	Sleep (5000)
	ControlClick("Google Chrome", "", $instance , "Left", 1, $continuex , $continuey)
	Sleep (5000)
	
	
	ControlClick("Google Chrome", "", $instance2 , "Left", 1, $linkx, $linky)
	Sleep (5000)
	ControlSend(WinWait ( "Google Chrome" ), "", $instance2 , "{F5}")
	Sleep (5000)	
	ControlClick("Google Chrome", "", $instance2 , "Left", 1, $agreex , $agreey)
	Sleep (5000)
	ControlClick("Google Chrome", "", $instance2 , "Left", 1, $loginx , $loginy)
	Sleep (5000)
	ControlClick("Google Chrome", "", $instance2 , "Left", 1, $continuex , $continuey)
	Sleep (5000)
	


	ELSE
	Sleep (100)
	EndIf

	
WEnd


 