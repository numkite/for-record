
#ifndef PE_HEADER //전처리기 지시자로 헤더 파일의 중복 포함을 방지
#define PE_HEADER // 만약 정의되어 있지 않다면 PE_PARSER_H 정의

#include <stdio.h>
#include <stdint.h>
#pragma pack(push, 1)

typedef struct {
	uint16_t e_magic; // "MZ"값
	uint16_t e_cblp;
	uint16_t e_cp;
	uint16_t e_crlc;
	uint16_t e_cparhdr;
	uint16_t e_minalloc;
	uint16_t e_maxalloc;
	uint16_t e_ss;
	uint16_t e_sp;
	uint16_t e_csum;
	uint16_t e_ip;
	uint16_t e_cs;
	uint16_t e_lfarlc;
	uint16_t e_ovno;
	uint16_t e_res[4];
	uint16_t e_oemid;
	uint16_t e_emoinfo;
	uint16_t e_res2[10];
	int32_t e_lfanew; // PE Header의 오프셋
} IMAGE_DOS_HEADER;


typedef struct {
	uint32_t Signature;
} PE_SIGNATURE;

typedef struct {
	uint16_t Machine;
	uint16_t NumberOfSections;
	uint32_t TimeDateStamp;
	uint32_t PointerToSymbolTable;
	uint32_t NumberOfSymbols;
	uint16_t SizeOfOptionalHeader;
	uint16_t Characteristics;
} IMAGE_FILE_HEADER;


typedef struct {
	uint16_t Magic;
	uint8_t MajorLinkerVersion;
	uint8_t MinorLinkerVersion;
	uint32_t SizeOfCode;
	uint32_t SizeOfInitializedData;
	uint32_t SizeOfUninitializedData;
	uint32_t AddressOfEntryPoint;
	uint32_t BaseOfCode;
	uint32_t ImageBase;
	uint32_t SectionAlignment;
	uint32_t FileAlignment;
	uint16_t MajorOperatingSystemVersion;
	uint16_t MinorOperatingSystemVersion;
	uint16_t MajorImageVersion;
	uint16_t MinorImageVersion;
	uint16_t MajorSubsystemVersion;
	uint16_t MinorSubsystemVersion;
	uint32_t SizeOfImage;
	uint32_t SizeOfHeader;
	uint32_t CheckSum;
	uint16_t Subsystem;
	uint16_t DllCharacteristics;
	uint32_t SizeOfStackReserve;
	uint32_t SizeOfStackCommit;
	uint32_t SizeOfHeapReserve;
	uint32_t SizeOfHeapCommit;
	uint32_t LoaderFlags;
	uint32_t NumberOfRvaAndSizes;
} IMAGE_OPTIONAL_HEADER;

typedef struct {
	PE_SIGNATURE Signature;
	IMAGE_FILE_HEADER FileHeader;
	IMAGE_OPTIONAL_HEADER OptionalHeader;
} IMAGE_NT_HEADERS;

#pragma pack(pop)


#endif //조건 끝맺음
