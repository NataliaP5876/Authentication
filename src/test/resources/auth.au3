$timeoutSec = 10;
$lookingSec = 0;
While $lookingSec < $timeoutSec
    ;Firefox or InternetExplorer or Chrome
    If WinExists("[CLASS:MozillaDialogClass]") _
        Or WinExists("[TITLE:Windows Security; CLASS:#32770]") _
            Or WinExists("[CLASS:Chrome_WidgetWin_1]", _
                                    "Authentication Required") Then
                ;вводим учетные данные
                ;им€ пользовател€
				Sleep(8000);
                Send("admin" & "{TAB}");
                ;пароль
                Send("admin123" & "{ENTER}");
                Exit;
    EndIf
    sleep(1000)
    $lookingSec += 1;
WEnd