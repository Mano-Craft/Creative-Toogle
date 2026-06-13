# OmniNX CFW Pack

[![Aktuelle Version](https://img.shields.io/badge/dynamic/json?url=https%3A%2F%2Fgit.niklascfw.de%2FOmniNX%2FOmniNX%2Fraw%2Fbranch%2Fmain%2F.github%2Fbadges%2Fdata.json&query=%24.omninx_pack_version&label=OmniNX%20Version&color=blue)](https://git.niklascfw.de/OmniNX/OmniNX/releases/latest)
[![Firmware](https://img.shields.io/badge/dynamic/json?url=https%3A%2F%2Fgit.niklascfw.de%2FOmniNX%2FOmniNX%2Fraw%2Fbranch%2Fmain%2F.github%2Fbadges%2Fdata.json&query=%24.switch_firmware&label=Kompatibel%20mit%20FW&color=189c11&logo=nintendoswitch)](https://git.niklascfw.de/OmniNX/NX_Firmware/releases)
[![OmniNX Pack Downloads](https://img.shields.io/badge/dynamic/json?url=https%3A%2F%2Fgit.niklascfw.de%2FOmniNX%2FOmniNX%2Fraw%2Fbranch%2Fmain%2F.github%2Fbadges%2Fdata.json&query=%24.release_zip_downloads_lifetime&label=OmniNX%20Downloads&color=6f42c1)](https://git.niklascfw.de/OmniNX/OmniNX/releases)

OmniNX ist ein vollständiges Custom-Firmware-Setup für die Nintendo Switch, verfügbar in drei Varianten mit Fokus auf Flexibilität und Modularität.

Vollständige Schritt-für-Schritt-Anleitungen: **[OmniNX Setup](https://docs.niklascfw.de/switch/omninx/einfuehrung/)**

## Vorschau
![](.pics/preview.gif)

## Features von OmniNX

- **Drei Varianten** – Light (minimal), Standard (voll) und OC (Alles aus Light/Standard + Extra Overclocking Tools)
- **Vollständiges CFW-Setup** – Sofort einsatzbereit mit Atmosphere, Hekate und wichtigen Tools
- **Ultrahand** – Overlay-Menü und Package-System (OmniNX Downloader, Alchemist, RAM Patcher und weitere...)
- **Vorinstallierte Payloads** – u. a. APL (Recovery), Lockpick RCM- & Pro, TegraExplorer, **[modchip_toolbox](https://github.com/DefenderOfHyrule/modchip-toolbox)**, OmniNX Installer
- **Sicherheit und Patches** – sys-patch, DNS-MitM
- **Modulare Struktur** – Build-Skripte für einfaches Erstellen der Packs
- **sys-ticon (Standard, damit auch OC)** – Home-Menü: eigene Icons, Titel, Herausgeber und Versionsanzeige ([sys-ticon](https://github.com/masagrator/sys-ticon))

## Varianten

**Light** ist die Basis, **Standard** baut auf Light auf, **OC** baut auf Standard auf – jede Variante enthält alles von der vorherigen plus die zusätzlichen Einträge.

| Variante | Beschreibung |
| -------- | ------------ |
| **Light** | Minimal: Kern-Apps, Overlays und Packages für den Alltag. |
| **Standard** | Wie Light, plus weitere Homebrew-Apps, Themes, Mod-Tools und Cheat-Overlay. |
| **OC** | Wie Standard, plus Overclocking: [Horizon OC](https://github.com/Horizon-OC/Horizon-OC), SaltyNX/SaltySD, FPSLocker. |

Schritt-für-Schritt-Anleitungen: **[NiklasCFW Docs – OmniNX Setup](https://docs.niklascfw.de/switch/omninx/einfuehrung/)**

## Inhalt von OmniNX

**Legende:** ✓ = enthalten · — = nicht enthalten

### Was ist in welcher Variante?

Orientierung an den [NiklasCFW Docs](https://docs.niklascfw.de/switch/omninx/einfuehrung/).

#### Homebrew-Apps

| App | Light | Standard | OC |
| --- | ----- | -------- | -- |
| Sphaira (HB-Menü) | ✓ | ✓ | ✓ |
| DBI | ✓ | ✓ | ✓ |
| Daybreak | ✓ | ✓ | ✓ |
| JKSV | ✓ | ✓ | ✓ |
| Linkalho | ✓ | ✓ | ✓ |
| DNS_mitm Tester | ✓ | ✓ | ✓ |
| Ultrahand Reload | ✓ | ✓ | ✓ |
| NXGallery | — | ✓ | ✓ |
| Switch Theme Installer | — | ✓ | ✓ |
| ThemezerNX | — | ✓ | ✓ |
| SimpleModDownloader | — | ✓ | ✓ |
| SimpleModAlchemist | — | ✓ | ✓ |
| Breeze (Cheat-Manager) | — | ✓ | ✓ |
| CyberFoil | — | ✓ | ✓ |
| Cheats-Updater | — | ✓ | ✓ |
| Furmark-NX | — | — | ✓ |
| swr-ini-tool | — | — | ✓ |

#### Ultrahand-Packages

*(offload)* = liegt in `switch/.packages/.offload/`, standardmäßig deaktiviert; Aktivierung nur über das UltraHand-**Package Manager**-Package.

| Package | Light | Standard | OC |
| ------- | ----- | -------- | -- |
| OmniNX Downloader | ✓ | ✓ | ✓ |
| RebootNX | ✓ | ✓ | ✓ |
| Alchemist | ✓ | ✓ | ✓ |
| Cool Curves | ✓ | ✓ | ✓ |
| Package Manager | ✓ | ✓ | ✓ |
| RAM Patcher *(offload)* | ✓ | ✓ | ✓ |
| Memory Kit / Memory Config *(offload)* | ✓ | ✓ | ✓ |
| Installer Configurator *(offload)* | ✓ | ✓ | ✓ |

#### Overlays

*(offload)* = liegt in `switch/.overlays/.offload/`, ebenfalls per **Package Manager** ein- und ausschaltbar.

| Overlay | Light | Standard | OC |
| ------- | ----- | -------- | -- |
| HOC Monitor | ✓ | ✓ | ✓ |
| QuickNTP | ✓ | ✓ | ✓ |
| Sysmodules (ovlSysmodules) | ✓ | ✓ | ✓ |
| Ultrahand-Menü (ovlmenu) | ✓ | ✓ | ✓ |
| sys-patch Overlay *(offload)* | ✓ | ✓ | ✓ |
| DNS-MitM Manager *(offload)* | ✓ | ✓ | ✓ |
| MasterVolume *(offload)* | ✓ | ✓ | ✓ |
| EdiZon (Cheats) | — | ✓ | ✓ |
| sys-ticon | — | ✓ | ✓ |
| Horizon OC Overlay | — | — | ✓ |
| FPSLocker | — | — | ✓ |
| ReverseNX-RT | — | — | ✓ |

#### OC / System (nur OC-Variante)

| Komponente | Light | Standard | OC |
| -------- | ----- | -------- | -- |
| [Horizon OC](https://github.com/Horizon-OC/Horizon-OC) (KIP, hoc-clk) | — | — | ✓ |
| SaltyNX | — | — | ✓ |
| SaltySD | — | — | ✓ |
| Gepatchtes `exosphere.bin` | — | — | ✓ |
| FPSLocker-Patch-Entpackung (`boot_package.ini`) | — | — | ✓ |

### Basis in allen Varianten (nicht in der Docs-Tabelle)

* **[Atmosphere](https://github.com/Atmosphere-NX/Atmosphere)**, **[Hekate](https://github.com/CTCaer/hekate)** / Nyx, **[sys-patch](https://github.com/borntohonk/sys-patch)**, **[Ultrahand](https://github.com/ppkantorski/Ultrahand-Overlay)**
* Payloads: **[APL](https://git.niklascfw.de/OmniNX/AllgemeinerProblemLoeser)**, Lockpick RCM, **[Lockpick RCM Pro](https://github.com/sthetix/Lockpick_RCM_Pro)**, TegraExplorer, **[modchip_toolbox](https://github.com/DefenderOfHyrule/modchip-toolbox)**, **[OmniNX Installer](https://git.niklascfw.de/OmniNX/OmniNX-Installer-Payload)**
* DNS-MitM (Hosts), USB 3.0 Force, OmniNX Sphaira-Theme, Boot-Logos, HorizonOS-Logo-Patch, **[MasterVolume](https://github.com/averne/MasterVolume)**-IPS-Patch, `exosphere.ini` (optional)

> **sys-clk** / Sys-Clk Manager: nicht fest im Pack; optional über **OmniNX Downloader** (in den Docs teils noch als OC-Eintrag geführt).

## Repository-Struktur

```
OmniNX/
├── .github/
│   ├── badges/
│   │   └── data.json # README-Shields (Version, FW, Download-Lifetime); täglich per CI scripts/update-badge-data.py
│   └── workflows/
├── staging/          # Gemeinsame Install-Stage-Dateien (Bootloader, Payloads, Nyx, etc.)
├── variants/         # Varianten-Inhalt
│   ├── light/        # Light-Variante (minimal)
│   ├── standard/     # Standard-Variante (voll)
│   └── oc/           # OC-Variante (Overclocking + SaltySD)
├── scripts/          # Build-Skripte
│   ├── build-all.sh      # macOS / Linux
│   └── build-all.ps1     # Windows (PowerShell)
├── VERSION           # Version (wird in die Packs eingetragen)
└── output/           # Erstellte ZIP-Archive (wird beim Build erstellt)
```

## Packs bauen

### Voraussetzungen

- **macOS / Linux:** Bash, `zip`
- **Windows:** [PowerShell](https://learn.microsoft.com/powershell/) 5.1+ oder PowerShell 7 (ZIP ohne externes `zip`)

### Alle Varianten bauen

**macOS / Linux:**

```bash
./scripts/build-all.sh
```

**Windows:**

```powershell
.\scripts\build-all.ps1
```

Die Version wird aus der Datei `VERSION` gelesen und in `manifest.ini` sowie die ZIP-Dateinamen übernommen. Die fertigen Packs liegen in `output/`.

## Installation

> **Hinweis:** Ausführlichere Schritt-für-Schritt-Guides (Voraussetzungen, Download, emuMMC, Einrichtung, Updates) lassen sich in den **[NiklasCFW Docs – OmniNX Setup](https://docs.niklascfw.de/switch/omninx/einfuehrung/)** übersichtlicher nachverfolgen als diese Kurzliste.

1. **SD-Karte vorbereiten** – Als **FAT32** formatieren, falls nötig (neue microSD oder noch kein FAT32).
2. **Dateien kopieren** – **Nur den Inhalt** des gewünschten **Varianten-ZIPs** auf die **microSD-Root** entpacken; wenn der Entpacker zum **Überschreiben** vorhandener Dateien auffordert, bestätigen. **Wechsel von einem anderen Pack** zu OmniNX: die microSD **nicht** leerformatieren – nur die ZIP-Inhalte wie beschrieben aufspielen und Überschreiben zulassen.
3. **Installation** – Beim Start vom Hekate OmniNX Installer Payload auswählen und Anweisungen befolgen

## Verwendung

### Hekate: Boot-Einträge und Payloads

- **CFW-EmuMMC** – Custom Firmware mit EmuMMC
- **OFW** – Original-Firmware
- **OmniNX Installer** – Pack-Installation / Staging (siehe Installation)
- **TegraExplorer** – Dateisystem-Explorer (RCM-Payload)
- **Lockpick RCM** / **Lockpick RCM Pro** – Key-Extraktion (Pro: u. a. PRODINFO)
- **AllgemeinerProblemLoeser (APL)** – Recovery ohne PC
- **modchip_toolbox** – HWFLY & PicoFly (siehe **Basis in allen Varianten**)

Vollständige Payload-Liste: Abschnitt **„Basis in allen Varianten“** oben.

### Packages und Overlays

- **L + R + PLUS** – Ultrahand-Overlay öffnen

### Homebrew-Menü

- **Album** – Sphaira starten (OmniNX-Theme)

## Lizenz

Die verwendeten Projekte unterliegen ihren jeweiligen Lizenzen; maßgeblich sind die Lizenzdateien der jeweiligen Upstream-Repositories. Das OmniNX-Pack selbst steht unter der MIT-Lizenz.

**[GPL 2.0](https://github.com/Atmosphere-NX/Atmosphere/blob/master/LICENSE):**

- [Atmosphere](https://github.com/Atmosphere-NX/Atmosphere)

## Credits

- **Atmosphere Team** – Custom Firmware
- **CTCaer** – Hekate Bootloader
- **ppkantorski** – Ultrahand Overlay
- **ITotalJustice** – Sphaira, DNS_mitm Tester und mehr
- **DefenderOfHyrule** – [modchip_toolbox](https://github.com/DefenderOfHyrule/modchip-toolbox)
- **WerWolv** – Tesla-Menü & EdiZon
- **Sthetix** – Lockpick RCM Pro
- **MasaGratoR (masagrator)** – [sys-ticon](https://github.com/masagrator/sys-ticon), [SaltyNX](https://github.com/masagrator/SaltyNX), [FPSLocker](https://github.com/masagrator/FPSLocker), [Status Monitor](https://github.com/masagrator/Status-Monitor-Overlay), [ReverseNX-RT](https://github.com/masagrator/ReverseNX-RT)
- **Horizon-OC** – [Horizon OC](https://github.com/Horizon-OC/Horizon-OC) (Overclocking, KIP, OC-Overlay)
- **luketanti** – [CyberFoil](https://github.com/luketanti/CyberFoil)
- **averne** – [MasterVolume](https://github.com/averne/MasterVolume)
- **NiklasCFW** & **Woody-NX** – OmniNX-Pack; [PatchExtractor](https://git.niklascfw.de/OmniNX/PatchExtractor), [swr-ini-tool](https://git.niklascfw.de/OmniNX/swr-ini-tool); Vorgänger NiklasCFW Pack

---

<div align="center">

### Socials/Support

[![Discord](https://img.shields.io/discord/733728731432091648?logo=discord&logoColor=white&label=NiklasCFW%20Modding%20Community&color=5865F2)](https://discord.gg/5rMJ4fWQT3)
[![YouTube Channel](https://img.shields.io/youtube/channel/subscribers/UCdEkFmAShnlE15CCimAwnYg?logo=youtube&label=NiklasCFW&color=ff0000)](https://www.youtube.com/@NiklasCFW)

</div>


