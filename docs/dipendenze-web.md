# Installazione dipendenze web

Tutte le dipendenze web saranno disponibili nella folder

_modulo-portlet/src/main/resources/META-INF/resources/libs_

Questa folder viene rigenerata ad ogni build.

## Dipendenze disponibili su [npmjs](https://www.npmjs.com/) 


Gli step necessari per l'installazione, su un modulo portlet, di dipendenze web disponibili su npmjs sono:

- Aggiungere al package.json del modulo la dipendenza
- La prima volta, lanciare il task gradle npmInstall <sup>1</sup>
- Da file system, individuare la dipendenza installata in ${parentModule}/node_modules e verificare la struttura delle cartelle, fino a trovare gli script ottimizzati per l'importazione web
- Configurare un task copy sul Gruntfile.js del modulo portlet
- Lanciare la build del modulo portlet
- Verificare che la dipendenza sia stata copiata nella folder libs (da eclipse è necessario effettuare un refresh-f5 del progetto)
- Importare i file js e css dalle properties della portlet


<sup>1</sup>  <img src="docs/imgs/gradle-task-npminstall.png">

## Dipendenze non disponibili su npmjs

In alcuni casi, le dipendenze web potrebbero non essere state uploadate su npmjs (o uploadate non dai manutentori del progetto, con eventuali rischi di sicurezza).
In questo caso, per effettuare l'importazione sul modulo portlet è necessario:

- Copiare i file nella folder  _${parentProject}_/alpaca/commonlibs_  (valutare se creare una cartella contenitore della dipendenza, utile nei casi in cui sono presenti più file o file js + css )
- Se non è già presente, aggiungere al gruntfile.js il task di copy delle commonlibs
- Lanciare la build del modulo portlet
- Verificare che la dipendenza sia stata copiata nella folder libs (da eclipse è necessario effettuare un refresh-f5 del progetto)
- Importare i file js e css dalle properties della portlet