
SUMMARY = "psycopg2 - Python-PostgreSQL Database Adapter"
HOMEPAGE = "https://psycopg.org/"
AUTHOR = "Federico Di Gregorio <fog@initd.org>"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=89ae5da7594f6112905b3a7b0c76ff7f"
DEPENDS = "postgresql"

SRC_URI = "${PYPI_SRC_URI} \
           https://files.pythonhosted.org/packages/c9/5e/dc6acaf46d78979d6b03458b7a1618a68e152a6776fce95daac5e0f0301b/psycopg2-2.9.9.tar.gz \
           file://0001-Modified-for-bitbake.patch \
           "
SRC_URI[md5sum] = "eae35fa97cdc92b910b706c720a257c7"
SRC_URI[sha256sum] = "d1454bde93fb1e224166811694d600e746430c006fbb031ea06ecc2ea41bf156"

S = "${WORKDIR}/psycopg2-2.9.9"

RDEPENDS_${PN} = ""

inherit setuptools3 pypi
