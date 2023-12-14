SYSTEMD_AUTO_ENABLE:${PN} = "enable"

pkg_postinst_ontarget:${PN}(){
	${bindir}/${PN}-setup initdb
}