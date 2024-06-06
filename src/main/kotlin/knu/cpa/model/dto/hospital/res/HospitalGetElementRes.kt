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
        name = hospital.name,
        address = hospital.address,
        latitude = hospital.latitude,
        longitude = hospital.longitude,
        contact = hospital.contact
    )
}
