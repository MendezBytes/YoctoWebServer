# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# TODO: Set this  with the path to your assignments rep.  Use ssh protocol and see lecture notes
# about how to setup ssh-agent for passwordless access
SRC_URI = "git://git@github.com/cu-ecen-aeld/final-project-Silex93.git;protocol=ssh;branch=main"


PV = "1.0+git${SRCPV}"
# TODO: set to reference a specific commit hash in your assignment repo
SRCREV = "a4d77b8cff657c013aba4cd8a44b2b6b0081e2cc"

# This sets your staging directory based on WORKDIR, where WORKDIR is defined at 
# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-WORKDIR
# We reference the "server" directory here to build from the "server" directory
# in your assignments repo
inherit module
inherit update-rc.d 

S = "${WORKDIR}/git/mpl3115a2_driver"


RPROVIDES:${PN} += "kernel-module-mpl3115a2"



INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "tempsensor_load"


FILES:${PN} += "${bindir}/*"
FILES:${PN} += "${sysconfdir}/*"



# TODO: customize these as necessary for any libraries you need for your application
# (and remove comment)
#TARGET_LDFLAGS += "-pthread -lrt"

do_configure () {
	:
}

do_compile () {
	unset LDFLAGS
	oe_runmake LD="${KERNEL_LD}"
}

do_install () {
	# TODO: Install your binaries/scripts here.
	# Be sure to install the target directory with install -d first
	# Yocto variables ${D} and ${S} are useful here, which you can read about at 
	# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-D
	# and
	# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-S
	install -d ${D}${bindir}
	install -m 0755 ${S}/mpl3115a2.ko ${D}${bindir}/
	
	install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/tempsensor_load ${D}${sysconfdir}/init.d/
}
