# Ruta al instalador de Chrome 114 en la carpeta raíz del proyecto
$chromeInstallerPath = ".\Google_Chrome_114.exe"

# Función para desinstalar Google Chrome si está presente
function Uninstall-Chrome {
    $chromeUninstallPath = (Get-ItemProperty -Path "HKLM:\Software\Microsoft\Windows\CurrentVersion\Uninstall\*",
                                             "HKLM:\Software\Wow6432Node\Microsoft\Windows\CurrentVersion\Uninstall\*",
                                             "HKCU:\Software\Microsoft\Windows\CurrentVersion\Uninstall\*") |
                           Where-Object { $_.DisplayName -like "Google Chrome*" } |
                           Select-Object -ExpandProperty UninstallString

    if ($chromeUninstallPath) {
        Write-Output "Desinstalando la versión actual de Chrome..."
        Start-Process -FilePath "cmd.exe" -ArgumentList "/c", $chromeUninstallPath, "/silent", "/norestart" -Wait
        Start-Sleep -Seconds 10  # Espera para completar la desinstalación
        Write-Output "Chrome desinstalado."
    } else {
        Write-Output "No se encontró una instalación de Chrome para desinstalar."
    }
}

# Verifica si Chrome está instalado y su versión
$chromePath = (Get-ItemProperty -Path "HKLM:\Software\Microsoft\Windows\CurrentVersion\App Paths\chrome.exe").'(default)'
$chromeVersion = ""

if ($chromePath) {
    $chromeVersion = (Get-Item $chromePath).VersionInfo.ProductVersion
}

# Si Chrome no está instalado o la versión no es 114, desinstala e instala Chrome 114
if (-not $chromeVersion -or $chromeVersion -notlike "114.*") {
    if ($chromeVersion) {
        Uninstall-Chrome
    }

    Write-Output "Instalando Chrome 114..."
    Start-Process -FilePath $chromeInstallerPath -ArgumentList "/silent /install" -Wait
    Write-Output "Chrome 114 instalado."
} else {
    Write-Output "Chrome 114 ya está instalado."
}
