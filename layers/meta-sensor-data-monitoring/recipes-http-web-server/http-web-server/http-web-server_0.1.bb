# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://webserver.c \
           file://queue.h \
           file://Makefile \
           file://webserver-start-stop.sh"

inherit update-rc.d 

S = "${WORKDIR}"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "webserver-start-stop.sh"


FILES:${PN} += "${bindir}/webserver"


TARGET_LDFLAGS += "-pthread -lrt"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}



do_install(){
	install -d ${D}${bindir}
	install -m 0755 ${S}/webserver ${D}${bindir}/
	install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/webserver-start-stop.sh ${D}${sysconfdir}/init.d/
}
