
SUMMARY = "PostgreSQL database adapter for Python"
HOMEPAGE = "https://psycopg.org/psycopg3/"
AUTHOR = "Daniele Varrazzo <daniele.varrazzo@gmail.com>"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = "https://files.pythonhosted.org/packages/4f/2b/fd8aaf32f8cae7efccb575da95e13f38d2b1062805ec96b37a3e8a98e84c/psycopg-3.1.14.tar.gz"
SRC_URI[md5sum] = "d824000a9c64ce980371a7efcbab1da3"
SRC_URI[sha256sum] = "7a63249f52e9c312d2d3978df5f170d21a0defd3a0c950d7859d226b7cfbfad5"

S = "${WORKDIR}/psycopg-3.1.14"

RDEPENDS_${PN} = "python-typing-extensions"

inherit setuptools3
