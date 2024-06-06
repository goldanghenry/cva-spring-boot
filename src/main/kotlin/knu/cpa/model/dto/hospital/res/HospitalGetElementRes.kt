package knu.cpa.model.dto.hospital.res

import knu.cpa.model.entity.Hospital

data class HospitalGetElementRes(
    val name: String,
    val address: String?,
    val latitude: Float?,
    val longitude: Float?,
    val contact: String?
){
    constructor(hospital: Hospital): this(
        name = hospital.name.split("\r").first(),
        address = hospital.address?.split("\r")?.first(),
        latitude = hospital.latitude,
        longitude = hospital.longitude,
        contact = hospital.contact?.split("\r")?.first()
    )
}
