FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

pkg_postinst_ontarget:${PN}(){
	touch /home/root/test.txt
	${bindir}/${PN}postgresql-setup initdb
}