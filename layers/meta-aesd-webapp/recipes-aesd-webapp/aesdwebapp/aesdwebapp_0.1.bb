LICENSE = "CLOSED"
SRC_URI = "git://github.com/Silex93/aesdFlaskApp.git;protocol=https;branch=master"
SRCREV = "463a254e29da304b940ccc79978a91b96dd414f4"
S = "${WORKDIR}/git"


inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_PACKAGES = "aesdwebapp"
SYSTEMD_SERVICE:${PN} = "aesdFlaskApp.service"


SRC_URI:append = " file://aesdFlaskApp.service "

FILES:${PN} += "${bindir}/aesdFlaskApp ${bindir}/aesdFlaskApp/*  ${systemd_unitdir}/system/aesdFlaskApp.service"

do_install () {
	#Install the flask application directories and files in /usr/bindir
	install -d ${D}${bindir}
	install -d ${D}${bindir}/aesdFlaskApp
	install -d ${D}${bindir}/aesdFlaskApp/templates
	
	install -m 0755 ${S}/app.py ${D}${bindir}/aesdFlaskApp/
	install -m 0755 ${S}/templates/index.html ${D}${bindir}/aesdFlaskApp/templates/
	
	#Install the startup script
	install -d ${D}/${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/aesdFlaskApp.service ${D}/${systemd_unitdir}/system
	
}