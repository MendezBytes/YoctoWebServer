# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://mpl3115a2.ko\
           file://tempsensor_load.sh\
           file://tempsensor_unload.sh"

inherit update-rc.d 

S = "${WORKDIR}"


INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "tempsensor_load"


FILES:${PN} += "${bindir}/*"
FILES:${PN} += "${sysconfdir}/*"


do_install(){
	install -d ${D}${bindir}
	install -m 0755 ${S}/mpl3115a2.ko ${D}${bindir}/
	
	install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/tempsensor_load.sh ${D}${sysconfdir}/init.d/
}
